package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bin Liu
 * @date 2021-08-11-7:58 PM
 */

@Setter
@Getter
public class ProductsDetailsX1 {
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 起始日期
     */
    private String startDate;

    /**
     * 终止日期
     */
    private String endDate;

}
