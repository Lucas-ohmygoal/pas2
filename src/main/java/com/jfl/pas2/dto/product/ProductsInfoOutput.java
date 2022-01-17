package com.jfl.pas2.dto.product;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-05-4:34 PM
 */

public class ProductsInfoOutput {
    private List<ProductsInfoZ1> productsInfoZ1s;

    public List<ProductsInfoZ1> getProductsInfoZ1s() {
        return productsInfoZ1s;
    }

    public void setProductsInfoZ1s(List<ProductsInfoZ1> productsInfoZ1s) {
        this.productsInfoZ1s = productsInfoZ1s;
    }
}
