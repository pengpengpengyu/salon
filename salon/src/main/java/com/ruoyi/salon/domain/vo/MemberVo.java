package com.ruoyi.salon.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class MemberVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
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

    /**
     * 最近消费日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastCustomDate;

    /**
     * 项目列表
     */
    private List<MemberItemRelVo> items;
}
