package com.ruoyi.salon.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * <p>
 * 次数消费记录
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class TimesConsumeRecordVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 次数消费记录id
     */
    private Long timesConsumeRecordId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 手机号
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
     * 消费次数
     */
    private Integer consumeTimes;

    /**
     * 原始次数
     */
    private Integer timesOriginal;

    /**
     * 原始赠送次数
     */
    private Integer giveTimesOriginal;

    /**
     * 剩余次数
     */
    private Integer timesAfter;

    /**
     * 剩余赠送次数
     */
    private Integer giveTimesAfter;

    /**
     * 消费日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate consumeDate;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 备注
     */
    private String remark;

}
