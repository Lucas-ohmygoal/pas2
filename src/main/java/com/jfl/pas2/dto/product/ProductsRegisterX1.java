package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Bin Liu
 * @date 2021-07-30-5:42 PM
 */

@Getter
@Setter
public class ProductsRegisterX1 {

    /**
     * 登录用户号
     */
    private String userId;

    /**
     * 产品型号
     */
    private String productType;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品代码
     */
    private String productCode;

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
     * 立柱规格
     */
    private String productPillar;

    /**
     * 电机规格
     */
    private String productMotor;

    /**
     * 风杯规格
     */
    private String productCup;

    /**
     * 开关规格
     */
    private String productSwitch;

    /**
     * 产品库存
     */
    private BigDecimal productStock;

    /**
     * 预售价格
     */
    @Size(max = 4, message = "预售价格输入有误！")
    private BigDecimal productPrice;
}
