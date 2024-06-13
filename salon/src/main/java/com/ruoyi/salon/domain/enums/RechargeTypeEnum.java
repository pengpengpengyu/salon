package com.ruoyi.salon.domain.enums;

import lombok.Getter;

/**
 * @author pywang
 * @description 充值类型
 * @create 2024-06-13 21:32
 */
@Getter
public enum RechargeTypeEnum {
    BALANCE("0", "余额充值"),
    ITEM_TIMES("1", "项目次数充值");

    public final String code;

    public final String desc;

    RechargeTypeEnum(String coce, String desc) {
        this.code = coce;
        this.desc = desc;
    }
}
