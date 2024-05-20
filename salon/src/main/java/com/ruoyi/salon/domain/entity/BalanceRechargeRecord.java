package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 余额充值记录表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_balance_recharge_record")
public class BalanceRechargeRecord extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 余额充值记录id
     */
    @TableId(value = "balance_recharge_record_id", type = IdType.AUTO)
    private Long balanceRechargeRecordId;

    /**
     * 会员id
     */
    @TableField("member_id")
    private Long memberId;

    /**
     * 充值金额
     */
    @TableField("recharge_amount")
    private BigDecimal rechargeAmount;

    /**
     * 赠送金额
     */
    @TableField("give_amount")
    private BigDecimal giveAmount;

    /**
     * 活动名称
     */
    @TableField("activity_name")
    private String activityName;

    /**
     * 充值时间
     */
    @TableField("recharge_time")
    private LocalDateTime rechargeTime;

    /**
     * 支付方式 1微信 2支付宝 3现金 9其他
     */
    @TableField("pay_mode")
    private String payMode;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

}
