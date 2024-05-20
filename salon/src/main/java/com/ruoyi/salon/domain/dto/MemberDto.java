package com.ruoyi.salon.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

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
public class MemberDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 会员姓名
     */
    @NotBlank(message = "会员姓名不能为空")
    private String memberName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号码不能为空")
    private String mobileNo;

    /**
     * 性别 F女 M男
     */
    private String gender;

    /**
     * 充值余额
     */
    private BigDecimal rechargeBalance;

    /**
     * 赠送余额
     */
    private BigDecimal giveBalance;

    /**
     * 积分
     */
    @Min(value = 0, message = "积分不能小于0")
    private Integer integral;

    /**
     * 等级
     */
    private String level;

    /**
     * 标签
     */
    private String label;

    /**
     * 介绍人
     */
    private String introducer;

    /**
     * 备注
     */
    private String remark;

}
