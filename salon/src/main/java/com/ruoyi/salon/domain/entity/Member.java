package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_member")
public class Member extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "member_id", type = IdType.AUTO)
    private Long memberId;

    /**
     * 会员姓名
     */
    @TableField("member_name")
    private String memberName;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号
     */
    @TableField("mobile_no")
    private String mobileNo;

    /**
     * 性别 F女 M男
     */
    @TableField("gender")
    private String gender;

    /**
     * 充值余额
     */
    @TableField("recharge_balance")
    private BigDecimal rechargeBalance;

    /**
     * 赠送余额
     */
    @TableField("give_balance")
    private BigDecimal giveBalance;

    /**
     * 积分
     */
    @TableField("integral")
    private Integer integral;

    /**
     * 等级
     */
    @TableField("level")
    private String level;

    /**
     * 标签
     */
    @TableField("label")
    private String label;

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

    /**
     * 最近消费时间
     */
    @TableField("last_custom_date")
    private LocalDate lastCustomDate;

    /**
     * 删除会员编号(用于唯一索引)
     */
    @TableField("del_member_id")
    private Long delMemberId;

}
