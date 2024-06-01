package com.ruoyi.salon.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class TimesRechargeRecordDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 次数充值记录id
     */
    private Long timesRechargeRecordId;

    /**
     * 会员id
     */
    @NotNull(message = "会员编号不能为空")
    private Long memberId;

    /**
     * 项目id
     */
    @NotNull(message = "项目编号不能为空")
    private Long itemId;

    /**
     * 充值次数
     */
    @NotNull(message = "充值次数不能为空")
    private Integer rechargeTimes;

    /**
     * 充值金额
     */
    @NotNull(message = "充值金额不能为空")
    private BigDecimal rechargeAmount;

    /**
     * 赠送金额
     */
    @NotNull(message = "赠送金额不能为空")
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
    @NotBlank(message = "支付方式不能为空")
    private String payMode;

    /**
     * 备注
     */
    private String remark;

}
