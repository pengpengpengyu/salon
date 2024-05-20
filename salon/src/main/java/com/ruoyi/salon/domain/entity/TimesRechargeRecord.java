package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 次数充值记录表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_times_recharge_record")
public class TimesRechargeRecord extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 次数充值记录id
     */
    @TableId(value = "times_recharge_record_id", type = IdType.AUTO)
    private Long timesRechargeRecordId;

    /**
     * 会员id
     */
    @TableField("member_id")
    private Long memberId;

    /**
     * 项目id
     */
    @TableField("item_id")
    private Long itemId;

    /**
     * 充值次数
     */
    @TableField("recharge_times")
    private Integer rechargeTimes;

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
