package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员项目关联表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_member_item_rel")
public class MemberItemRel extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 会员项目关联id
     */
    @TableId(value = "member_item_rel_id", type = IdType.AUTO)
    private Long memberItemRelId;

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
    @TableField("times")
    private Integer times;

    /**
     * 赠送次数
     */
    @TableField("give_times")
    private Integer giveTimes;

}
