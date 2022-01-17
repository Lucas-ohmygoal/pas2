package com.jfl.pas2.dto.product;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-11-9:58 AM
 */

public class ProductsIncreaseInput {

    private List<ProductsIncreaseX1> productsIncreaseX1List;

    public List<ProductsIncreaseX1> getProductsIncreaseX1List() {
        return productsIncreaseX1List;
    }

    public void setProductsIncreaseX1List(List<ProductsIncreaseX1> productsIncreaseX1List) {
        this.productsIncreaseX1List = productsIncreaseX1List;
    }
}
