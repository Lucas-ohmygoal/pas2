package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Bin Liu
 * @date 2021-08-11-7:59 PM
 */

@Getter
@Setter
public class ProductsDetailsZ1 {
    /**
     * 出入库单号
     */
    private String operationSeries;

    /**
     * 产品编号
     */
    private String productId;

    /**
     * 产品增量
     */
    private BigDecimal productIncrement;

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

    /**
     * 操作员姓名
     */
    private String operationName;

    /**
     * 操作日期
     */
    private String operationDate;

    /**
     * 操作时间
     */
    private String operationTime;
}
