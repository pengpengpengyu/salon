package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * 余额消费记录表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_balance_consume_record")
public class BalanceConsumeRecord extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 余额消费记录id
     */
    @TableId(value = "balance_consume_record_id", type = IdType.AUTO)
    private Long balanceConsumeRecordId;

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
     * 项目名称
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 消费金额
     */
    @TableField("consume_amount")
    private BigDecimal consumeAmount;

    /**
     * 原始余额
     */
    @TableField("balance_original")
    private BigDecimal balanceOriginal;

    /**
     * 剩余余额
     */
    @TableField("balance_after")
    private BigDecimal balanceAfter;

    /**
     * 原始赠送余额
     */
    @TableField("give_balance_original")
    private BigDecimal giveBalanceOriginal;

    /**
     * 剩余赠送余额
     */
    @TableField("give_balance_after")
    private BigDecimal giveBalanceAfter;

    /**
     * 消费日期
     */
    @TableField("consume_date")
    private LocalDate consumeDate;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 进店渠道
     */
    @TableField("enter_store_channel")
    private String enterStoreChannel;

    /**
     * 介绍人
     */
    @TableField("introducer")
    private String introducer;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

}
