package com.ruoyi.salon.domain.dto;

import com.ruoyi.common.core.validation.AddGroup;
import com.ruoyi.common.core.validation.UpdateGroup;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 项目Dto
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class ItemDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @NotNull(groups = AddGroup.class, message = "项目编号不能为空")
    private Long itemId;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    private String itemName;

    /**
     * 价格
     */
    @NotNull(message = "项目价格不能为空")
    private BigDecimal price;

    /**
     * 折扣价格
     */
    private BigDecimal discountedPrice = this.price;

    /**
     * 描述
     */
    private String description;

    /**
     * 删除后的项目ID，用于唯一索引
     */
    private Long delItmeId;
}
