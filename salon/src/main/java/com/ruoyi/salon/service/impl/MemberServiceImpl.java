package com.ruoyi.salon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.enums.DelFlagEnum;
import com.ruoyi.salon.mapper.MemberMapper;
import com.ruoyi.salon.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
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

    private void checkUnionMember(Member member) {
        Member existsMember = lambdaQuery()
                .eq(Member::getMobileNo, member.getMobileNo())
                .eq(Member::getMemberName, member.getMemberName())
                .one();
        if (existsMember != null) {
            throw new ServiceException("该手机号对应的会员已存在!");
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
            throw new ServiceException("赠送余额 " + member.getGiveBalance() + errMsg);
        }

        if (member.getIntegral().compareTo(Integer.valueOf(0)) > 0) {
            throw new ServiceException("积分 " + member.getIntegral() + errMsg);
        }
        // TODO 剩余次数校验
        Member delMember = new Member();
        delMember.setMemberId(memberId);
        delMember.setDelMemberId(memberId);
        return delMember;
    }
}
