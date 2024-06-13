package com.ruoyi.salon.domain.dto;

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
    private Long memberId;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 赠送次数
     */
    private Integer giveTimes;

    /**
     * 充值类型
     */
    private String rechargeType;

}
