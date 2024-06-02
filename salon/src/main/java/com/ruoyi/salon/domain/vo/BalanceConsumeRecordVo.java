package com.ruoyi.salon.domain.vo;

import lombok.Getter;
import lombok.Setter;

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
public class BalanceConsumeRecordVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 余额消费记录id
     */
    private Long balanceConsumeRecordId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 消费金额
     */
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
