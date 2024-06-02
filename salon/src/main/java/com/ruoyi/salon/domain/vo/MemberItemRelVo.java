package com.ruoyi.salon.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>
 * 会员项目关联表
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Getter
@Setter
public class MemberItemRelVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /**
     * 会员项目关联id
     */
    private Long memberItemRelId;

    /**
     * 会员id
     */
    private Long memberId;

    /**
     * 项目id
     */
    private Long itemId;

    /**
     * 充值次数
     */
    private Integer times;

    /**
     * 会员名称
     */
    private String memberName;

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

}
