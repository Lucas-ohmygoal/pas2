package com.jfl.pas2.dto.product;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-11-10:00 AM
 */

public class ProductsDecreaseInput {
    private List<ProductsDecreaseX1> productsDecreaseX1List;

    public List<ProductsDecreaseX1> getProductsDecreaseX1List() {
        return productsDecreaseX1List;
    }

    public void setProductsDecreaseX1List(List<ProductsDecreaseX1> productsDecreaseX1List) {
        this.productsDecreaseX1List = productsDecreaseX1List;
    }
}
