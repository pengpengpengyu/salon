package com.ruoyi.salon.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 余额充值记录Dto
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class BalanceRechargeRecordVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 余额充值记录id
     */
    private Long balanceRechargeRecordId;

    /**
     * 会员id
     */
    private Long memberId;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
