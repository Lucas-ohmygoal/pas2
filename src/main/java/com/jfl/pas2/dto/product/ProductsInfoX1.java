package com.jfl.pas2.dto.product;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-08-05-4:34 PM
 */

@Getter
@Setter
public class ProductsInfoX1 {

    /**
     * 产品代码
     */
    private String productCode;

    /**
     * 查询条件
     */
    private String queryCondition;

    /**
     * 查询参数
     */
    private String queryParam;

}
