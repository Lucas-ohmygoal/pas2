package com.jfl.pas2.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Bin Liu
 * @date 2021-08-07-11:18 AM
 */

@Getter
@Setter
public class ProductsStorageZ1 {

    /**
     * 查询结果
     */
    private BigDecimal result;

    /**
     * 库存总量
     */
    private BigDecimal gross;

}
