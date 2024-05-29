package com.ruoyi.salon.service.impl;

import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.mapper.BalanceRechargeRecordMapper;
import com.ruoyi.salon.service.BalanceRechargeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.salon.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 余额充值记录表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class BalanceRechargeRecordServiceImpl extends ServiceImpl<BalanceRechargeRecordMapper, BalanceRechargeRecord> implements BalanceRechargeRecordService {

    @Resource
    private MemberService memberService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public BalanceRechargeRecord add(BalanceRechargeRecord record) {
        Member member = memberService.getById(record.getMemberId());
        member.setRechargeBalance(member.getRechargeBalance().add(record.getRechargeAmount()));
        member.setGiveBalance(member.getGiveBalance().add(record.getGiveAmount()));
        memberService.updateById(member);
        save(record);
        return record;
    }
}
