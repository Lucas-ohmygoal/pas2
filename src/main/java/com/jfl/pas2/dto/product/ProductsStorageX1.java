package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-07-11:17 AM
 */

@Getter
@Setter
public class ProductsStorageX1 {

    /**
     * 产品代码
     */
    private String productCode;

    /**
     * 产品型号
     */
    private List<String> productTypes;

    /**
     * 品牌名称
     */
    private List<String> productBrands;

    /**
     * 产品尺寸
     */
    private List<String> productSizes;

    /**
     * 产品颜色
     */
    private List<String> productColors;

    /**
     * 叶片规格
     */
    private List<String> productBlades;

    /**
     * 电机规格
     */
    private List<String> productMotors;

    /**
     * 立柱规格
     */
    private List<String> productPillars;

    /**
     * 开关规格
     */
    private List<String> productSwitches;
}
