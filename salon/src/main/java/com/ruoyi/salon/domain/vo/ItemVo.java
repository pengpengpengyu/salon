package com.ruoyi.salon.domain.vo;

import lombok.Getter;
import lombok.Setter;

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
public class ItemVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 折扣价格
     */
    private BigDecimal discountedPrice;

    /**
     * 描述
     */
    private String description;

    /**
     * 删除后的项目ID，用于唯一索引
     */
    private Long delItmeId;
}
