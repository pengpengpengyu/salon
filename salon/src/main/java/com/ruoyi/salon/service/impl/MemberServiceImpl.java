package com.ruoyi.salon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.salon.domain.entity.*;
import com.ruoyi.salon.domain.enums.DelFlagEnum;
import com.ruoyi.salon.domain.vo.MemberItemRelVo;
import com.ruoyi.salon.mapper.MemberMapper;
import com.ruoyi.salon.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    private BalanceRechargeRecordService balanceRechargeRecordService;
    @Resource
    private TimesRechargeRecordService timesRechargeRecordService;
    @Resource
    private MemberItemRelService memberItemRelService;
    @Resource
    private ItemService itemService;
    @Resource
    private BalanceConsumeRecordService balanceConsumeRecordService;
    @Resource
    private TimesConsumeRecordService timesConsumeRecordService;

    @Override
    public List<Member> list(Member member) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(member);
        queryWrapper.lambda().orderByDesc(Member::getMemberId);
        return list(queryWrapper);
    }

    @Override
    public Member add(Member member) {
        checkUnionMember(member);
        save(member);
        return member;
    }

    @Override
    public Member update(Member member) {
        checkUnionMember(member);
        updateById(member);
        return member;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean removeBatch(Set<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return false;
        }
        List<Member> members = ids.stream()
                .map(this::checkMemberForDel)
                .collect(Collectors.toList());
        updateBatchById(members);
        return removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean balanceRecharge(BalanceRechargeRecord record) {
        Member member = getById(record.getMemberId());
        member.setRechargeBalance(member.getRechargeBalance().add(record.getRechargeAmount()));
        member.setGiveBalance(member.getGiveBalance().add(record.getGiveAmount()));
        member.setUpdateBy(ShiroUtils.getLoginName());
        updateById(member);
        return balanceRechargeRecordService.save(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean timesRecharge(TimesRechargeRecord record) {
        MemberItemRel memberItemRel = new MemberItemRel();
        memberItemRel.setMemberId(record.getMemberId());
        memberItemRel.setItemId(record.getItemId());
        memberItemRel.setTimes(record.getRechargeTimes());
        memberItemRelService.addRelOrTimes(memberItemRel);
        timesRechargeRecordService.save(record);

        BalanceRechargeRecord balanceRechargeRecord = new BalanceRechargeRecord();
        balanceRechargeRecord.setMemberId(record.getMemberId());
        balanceRechargeRecord.setRechargeAmount(BigDecimal.ZERO);
        balanceRechargeRecord.setGiveAmount(record.getGiveAmount());
        return balanceRecharge(balanceRechargeRecord);
    }

    public Member queryByIdWithCheck(Long memberId) {
        Member member = getById(memberId);
        if (member == null) {
            throw new ServiceException("会员不存在");
        }
        return member;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean balanceConsume(BalanceConsumeRecord record) {
        // 1.会员表余额减扣并记录最后消费日期
        Member member = queryByIdWithCheck(record.getMemberId());
        Item item = itemService.queryByIdWithCheck(record.getItemId());

        record.setBalanceOriginal(member.getRechargeBalance());
        record.setGiveBalanceOriginal(member.getGiveBalance());

        BigDecimal rechargeBalanceAfCustom = member.getRechargeBalance();
        BigDecimal giveBalanceAfCustom = member.getGiveBalance();
        // 先扣充值余额再扣赠送余额
        rechargeBalanceAfCustom = rechargeBalanceAfCustom.subtract(record.getConsumeAmount());
        if (rechargeBalanceAfCustom.compareTo(BigDecimal.ZERO) < 0) {
            giveBalanceAfCustom = giveBalanceAfCustom.subtract(rechargeBalanceAfCustom.abs());
            if (giveBalanceAfCustom.compareTo(BigDecimal.ZERO) < 0) {
                throw new ServiceException("余额不足!");
            }
            rechargeBalanceAfCustom = BigDecimal.ZERO;
        }
        LocalDate lastCustomDate = convertLastCustomDate(member.getLastCustomDate(), record.getConsumeDate());
        updateBalance(member.getMemberId(), rechargeBalanceAfCustom, giveBalanceAfCustom, lastCustomDate);

        // 2.记录余额消费记录
        record.setBalanceAfter(rechargeBalanceAfCustom);
        record.setGiveBalanceAfter(giveBalanceAfCustom);
        record.setItemName(item.getItemName());
        return balanceConsumeRecordService.add(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean timesConsume(TimesConsumeRecord record) {
        // 1.修改会员项目关联表剩余次数
        Member member = queryByIdWithCheck(record.getMemberId());
        Item item = itemService.queryByIdWithCheck(record.getItemId());
        MemberItemRel memberItemRel = memberItemRelService.queryByMemberAndItemIdWithCheck(record.getMemberId(), record.getItemId());
        record.setTimesOriginal(memberItemRel.getTimes());

        Integer timesAfConsume = memberItemRel.getTimes();
        timesAfConsume = timesAfConsume - record.getConsumeTimes();
        if (timesAfConsume < 0) {
            throw new ServiceException("剩余次数不足");
        }
        MemberItemRel updateRel = new MemberItemRel();
        updateRel.setMemberItemRelId(memberItemRel.getMemberItemRelId());
        updateRel.setTimes(timesAfConsume);
        memberItemRelService.updateByRelId(updateRel);
        // 2.记录次数消费记录
        record.setItemName(item.getItemName());
        record.setTimesAfter(timesAfConsume);
        timesConsumeRecordService.add(record);
        // 3.修改会员表最后消费日期
        LocalDate lastCustomDate = convertLastCustomDate(member.getLastCustomDate(), record.getConsumeDate());
        updateBalance(member.getMemberId(), null, null, lastCustomDate);
        return true;
    }

    @Override
    public Boolean nonMemberConsume(BalanceConsumeRecord record) {
        Item item = itemService.queryByIdWithCheck(record.getItemId());
        record.setItemName(item.getItemName());
        record.setMemberId(getNonMember().getMemberId());
        return balanceConsumeRecordService.add(record);
    }

    /**
     * 获取最后消费日期
     *
     * @param currentLastCustomDate 当前最后消费日期
     * @param newLastCustomDate     新带最后消费日期
     * @return 最后消费日期
     */
    private LocalDate convertLastCustomDate(LocalDate currentLastCustomDate, LocalDate newLastCustomDate) {
        LocalDate lastCustomDate = Optional.ofNullable(newLastCustomDate).orElse(LocalDate.now());
        if (currentLastCustomDate != null && lastCustomDate.isBefore(currentLastCustomDate)) {
            return currentLastCustomDate;
        }
        return lastCustomDate;
    }

    /**
     * 修改余额
     *
     * @param memberId        会员编号
     * @param rechargeBalance 充值余额
     * @param giveBalance     赠送余额
     * @param lastCustomDate  最后消费日期
     */
    private void updateBalance(Long memberId, BigDecimal rechargeBalance, BigDecimal giveBalance, LocalDate lastCustomDate) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setRechargeBalance(rechargeBalance);
        member.setGiveBalance(giveBalance);
        member.setLastCustomDate(lastCustomDate);
        member.setUpdateBy(ShiroUtils.getLoginName());
        updateById(member);
    }

    private void checkUnionMember(Member member) {
        Member existsMember = lambdaQuery()
                .eq(Member::getMobileNo, member.getMobileNo())
                .eq(Member::getMemberName, member.getMemberName())
                .one();
        boolean isUpdate = member.getMemberId() != null;
        if (existsMember != null) {
            if (!isUpdate) {
                throw new ServiceException("该手机号对应的会员已存在!");
            }
            if (!existsMember.getMemberId().equals(member.getMemberId())) {
                throw new ServiceException("该手机号对应的会员已存在!");
            }
        }
    }

    private Member checkMemberForDel(Long memberId) {
        Member member = baseMapper.selectById(memberId);
        if (member == null) {
            throw new ServiceException("会员不存在,会员ID " + memberId);
        }
        String errMsg = " 不允许删除:" + memberId;

        if (member.getRechargeBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new ServiceException("余额剩余 " + member.getRechargeBalance() + errMsg);
        }

        if (member.getGiveBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new ServiceException("赠送余额剩余 " + member.getGiveBalance() + errMsg);
        }

        if (member.getIntegral().compareTo(Integer.valueOf(0)) > 0) {
            throw new ServiceException("积分剩余 " + member.getIntegral() + errMsg);
        }
        List<MemberItemRelVo> memberItemRelVos = memberItemRelService.queryRelForAllItemByMemberId(memberId);
        if (CollectionUtils.isNotEmpty(memberItemRelVos)) {
            throw new ServiceException("该会员下仍有项目" + errMsg);
        }
        Member delMember = new Member();
        delMember.setMemberId(memberId);
        delMember.setDelMemberId(memberId);
        return delMember;
    }

    @Override
    public Member getNonMember() {
        Member member = new Member();
        member.setMemberId(-1L);
        member.setMemberName("散客");
        return member;
    }
}
