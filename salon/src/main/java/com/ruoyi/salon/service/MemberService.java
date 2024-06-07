package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface MemberService extends IService<Member> {

    /**
     * 会员列表查询
     *
     * @param member 查询参数
     * @return 会员列表
     */
    List<Member> list(Member member);

    /**
     * 新增会员
     *
     * @param member 会员信息
     * @return 会员信息
     */
    Member add(Member member);

    /**
     * 修改会员
     *
     * @param member 会员信息
     * @return 会员信息
     */
    Member update(Member member);

    /**
     * 根据ID列表批量删除
     *
     * @param ids id列表
     * @return true/false
     */
    Boolean removeBatch(Set<Long> ids);

    /**
     * 余额充值
     *
     * @param record 余额充值记录
     * @return true/false
     */
    Boolean balanceRecharge(BalanceRechargeRecord record);

    /**
     * 次数充值
     * @param record 次数充值记录
     * @return true/false
      */
    Boolean timesRecharge(TimesRechargeRecord record);

    /**
     * 余额消费
     * @param record 消费记录
     * @return true/false
     */
    Boolean balanceConsume(BalanceConsumeRecord record);

    /**
     * 次数消费
     * @param record 消费记录
     * @return true/false
     */
    Boolean timesConsume(TimesConsumeRecord record);

    /**
     * 散客消费
     * @param record 消费记录
     * @return  true/false
     */
    Boolean nonMemberConsume(BalanceConsumeRecord record);

    /**
     * 获取散客会员
     * @return 散客会员编号
     */
    Member getNonMember();
}
