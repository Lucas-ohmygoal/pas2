package com.jfl.pas2.dto.product;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-11-7:58 PM
 */

public class ProductsDetailsOutput {
    List<ProductsDetailsZ1> productsDetailsZ1List;

    public List<ProductsDetailsZ1> getProductsDetailsZ1List() {
        return productsDetailsZ1List;
    }

    public void setProductsDetailsZ1List(List<ProductsDetailsZ1> productsDetailsZ1List) {
        this.productsDetailsZ1List = productsDetailsZ1List;
    }
}
