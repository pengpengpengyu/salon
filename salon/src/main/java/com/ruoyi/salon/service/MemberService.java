package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.ruoyi.salon.domain.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.entity.TimesRechargeRecord;

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
}
