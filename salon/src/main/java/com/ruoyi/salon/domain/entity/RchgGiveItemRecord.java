package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 充值赠送项目记录表
 * </p>
 *
 * @author pywang
 * @since 2024-06-12
 */
@Getter
@Setter
@TableName("t_rchg_give_item_record")
public class RchgGiveItemRecord extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 充值赠送项目记录id
     */
    @TableId(value = "rchg_give_item_record_id", type = IdType.AUTO)
    private Long rchgGiveItemRecordId;

    /**
     * 充值记录id
     */
    @TableField("recharge_record_id")
    private Long rechargeRecordId;

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
     * 赠送次数
     */
    @TableField("give_times")
    private Integer giveTimes;

    /**
     * 充值类型
     */
    @TableField("recharge_type")
    private String rechargeType;

}
