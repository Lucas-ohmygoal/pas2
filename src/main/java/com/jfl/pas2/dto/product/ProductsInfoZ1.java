package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Bin Liu
 * @date 2021-08-05-4:34 PM
 */

@Getter
@Setter
public class ProductsInfoZ1 {

    /**
     * 产品型号
     */
    private String productModelId;

    /**
     * 产品型号
     */
    private String productType;

    /**
     * 品牌名称
     */
    private String productBrand;

    /**
     * 产品尺寸
     */
    private String productSize;

    /**
     * 产品颜色
     */
    private String productColor;

    /**
     * 叶片规格
     */
    private String productBlade;

    /**
     * 电机规格
     */
    private String productMotor;

    /**
     * 成本价格
     */
    private BigDecimal productStock;

    /**
     * 预售价格
     */
    private BigDecimal sellingPrice;

}
