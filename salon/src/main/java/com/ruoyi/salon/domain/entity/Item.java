package com.ruoyi.salon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
@TableName("t_item")
public class Item extends MbBaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    /**
     * 项目名称
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 折扣价格
     */
    @TableField("discounted_price")
    private BigDecimal discountedPrice;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

}
