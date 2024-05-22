package com.ruoyi.salon.domain.enums;

import lombok.Getter;

/**
 * DelFlagEnum
 *
 * @author pywang
 * @version 1.0
 * @description 删除标识
 * @date 2024/5/22 21:19
 */
@Getter
public enum DelFlagEnum {
    NOT_DELETE("0", "未删除"),
    DELETED("1", "已删除");

    final String code;

    final String desc;

    DelFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
