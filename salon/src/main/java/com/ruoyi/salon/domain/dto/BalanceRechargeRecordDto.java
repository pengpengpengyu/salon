package com.ruoyi.salon.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class BalanceRechargeRecordDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 余额充值记录id
     */
    private Long balanceRechargeRecordId;

    /**
     * 会员id
     */
    @NotNull(message = "会员编号不能为空")
    private Long memberId;

    /**
     * 充值金额
     */
    @NotNull(message = "充值金额不能为空")
    @Min(value = 0, message = "充值金额不能小于0")
    private BigDecimal rechargeAmount;

    /**
     * 赠送金额
     */
    @NotNull(message = "赠送金额不能为空")
    @Min(value = 0, message = "赠送金额不能小于0")
    private BigDecimal giveAmount;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 充值时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rechargeTime = LocalDateTime.now();

    /**
     * 支付方式 1微信 2支付宝 3现金 9其他
     */
    @NotBlank(message = "支付方式不能为空")
    private String payMode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 赠送项目
     */
    @Valid
    private List<RchgGiveItemRecordDto> giveItemRecords;

}
