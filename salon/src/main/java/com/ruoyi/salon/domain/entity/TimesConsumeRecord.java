package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <p>
 * 次数消费记录表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_times_consume_record")
public class TimesConsumeRecord extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 次数消费记录id
     */
    @TableId(value = "times_consume_record_id", type = IdType.AUTO)
    private Long timesConsumeRecordId;

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
     * 消费次数
     */
    @TableField("consume_times")
    private Integer consumeTimes;

    /**
     * 原始次数
     */
    @TableField("times_original")
    private Integer timesOriginal;

    /**
     * 原始赠送次数
     */
    @TableField("give_times_original")
    private Integer giveTimesOriginal;

    /**
     * 剩余次数
     */
    @TableField("times_after")
    private Integer timesAfter;

    /**
     * 剩余赠送次数
     */
    @TableField("give_times_after")
    private Integer giveTimesAfter;

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
     * 备注
     */
    @TableField("remark")
    private String remark;

}
