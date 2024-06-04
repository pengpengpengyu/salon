package com.ruoyi.salon.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 余额消费Dto
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class BalanceConsumeRecordDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 余额消费记录id
     */
    private Long balanceConsumeRecordId;

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
     * 项目名称
     */
    private String itemName;

    /**
     * 消费金额
     */
    @NotNull(message = "消费金额不能为空")
    private BigDecimal consumeAmount;

    /**
     * 原始余额
     */
    private BigDecimal balanceOriginal;

    /**
     * 剩余余额
     */
    private BigDecimal balanceAfter;

    /**
     * 原始赠送余额
     */
    private BigDecimal giveBalanceOriginal;

    /**
     * 剩余赠送余额
     */
    private BigDecimal giveBalanceAfter;

    /**
     * 消费日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate consumeDate;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 进店渠道
     */
    private String enterStoreChannel;

    /**
     * 介绍人
     */
    private String introducer;

    /**
     * 备注
     */
    private String remark;

}
