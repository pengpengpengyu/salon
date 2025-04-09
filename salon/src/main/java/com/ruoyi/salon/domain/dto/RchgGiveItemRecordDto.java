package com.ruoyi.salon.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class RchgGiveItemRecordDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 充值赠送项目记录id
     */
    private Long rchgGiveItemRecordId;

    /**
     * 充值记录id
     */
    private Long rechargeRecordId;

    /**
     * 会员id
     */
    @NotNull
    private Long memberId;

    /**
     * 项目id
     */
    @NotNull
    private Long itemId;

    /**
     * 赠送次数
     */
    @NotNull(message = "赠送次数不能为空")
    @Min(value = 1, message = "赠送次数不能小于1")
    private Integer giveTimes;

    /**
     * 充值类型
     */
    private String rechargeType;

}
