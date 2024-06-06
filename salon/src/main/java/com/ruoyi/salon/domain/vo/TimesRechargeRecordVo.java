package com.ruoyi.salon.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 次数充值记录表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class TimesRechargeRecordVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 次数充值记录id
     */
    private Long timesRechargeRecordId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 手机号码
     */
    private String mobileNo;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 充值次数
     */
    private Integer rechargeTimes;

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;

    /**
     * 赠送金额
     */
    private BigDecimal giveAmount;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 充值时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime rechargeTime;

    /**
     * 支付方式 1微信 2支付宝 3现金 9其他
     */
    private String payMode;

    /**
     * 备注
     */
    private String remark;

}
