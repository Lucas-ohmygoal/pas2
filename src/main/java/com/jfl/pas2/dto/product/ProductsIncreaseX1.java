package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Bin Liu
 * @date 2021-08-11-9:59 AM
 */

@Getter
@Setter
public class ProductsIncreaseX1 {

    /**
     * 用户号
     */
    private String userId;

    /**
     * 操作序列号
     */
    private String operationSeries;

    /**
     *产品编号
     */
    private String productId;

    /**
     * 产品数量
     */
    private BigDecimal number;

    /**
     * 是否带有风杯
     */
    private String withCups;

    /**
     * 是否带有风杯
     */
    private String withSwitches;

    /**
     * 是否带有中环
     */
    private String withCircles;
}
