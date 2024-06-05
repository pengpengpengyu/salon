package com.ruoyi.salon.domain.enums;

import lombok.Getter;

/**
 * DictTypeEnum
 *
 * @author pywang
 * @version 1.0
 * @description 字典类型枚举
 * @date 2024/5/22 21:19
 */
@Getter
public enum DictTypeEnum {
    SEX("sys_user_sex", "性别"),
    SALON_MEMBER_LEVEL("salon_member_level", "会员等级"),
    SALON_PAY_MODE("salon_pay_mode", "充值方式"),
    SAON_EN("salon_enter_store_channel", "进店渠道");

    final String code;

    final String desc;

    DictTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
