package com.ruoyi.salon.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
public class TimesConsumeRecordDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 次数消费记录id
     */
    private Long timesConsumeRecordId;

    /**
     * 会员id
     */
    @NotNull(message = "会员编号不能为空")
    private Long memberId;

    /**
     * 项目id
     */
    @NotNull(message = "项目编号不能为空")
    private Long itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 消费次数
     */
    @Min(value = 1, message = "消费次数不能小于1")
    @NotNull(message = "消费次数不能为空")
    private Integer consumeTimes;

    /**
     * 原始次数
     */
    private Integer timesOriginal;

    /**
     * 剩余次数
     */
    private Integer timesAfter;

    /**
     * 消费日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
