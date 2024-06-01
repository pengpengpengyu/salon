package com.ruoyi.salon.domain.vo;

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
public class TimesRechargeRecordVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 次数充值记录id
     */
    private Long timesRechargeRecordId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 充值次数
     */
    private Integer rechargeTimes;

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;

    /**
     * 赠送金额
     */
    private BigDecimal giveAmount;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 充值时间
     */
    private LocalDateTime rechargeTime;

    /**
     * 支付方式 1微信 2支付宝 3现金 9其他
     */
    private String payMode;

    /**
     * 备注
     */
    private String remark;

}
