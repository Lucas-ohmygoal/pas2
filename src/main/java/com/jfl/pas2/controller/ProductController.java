package com.jfl.pas2.controller;

import com.jfl.pas2.dto.product.*;
import com.jfl.pas2.service.ProductsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author Bin Liu
 * @date 2021-07-30-5:33 PM
 */

@RestController
@RequestMapping("/product")
@ResponseBody
public class ProductController {

    @Autowired
    private ProductsService productsService;

    /**
     * 产品信息登记
     * @param input
     * @return
     */

    @PostMapping("/register")
    public ProductsRegisterOutput registerProducts(@RequestBody ProductsRegisterInput input) throws JSONException, ParseException {
        return productsService.registerProducts(input.getProductsRegisterX1());
    }

    /**
     * 产品信息查询
     * @param input
     * @return
     */

    @PostMapping("/info")
    public ProductsInfoOutput productsInfos(@RequestBody ProductsInfoInput input){
        return productsService.productsInfos(input.getProductsInfoX1());
    }

    /**
     * 库存查询
     * @param input
     * @return
     */

    @PostMapping("/stock")
    public ProductsStorageOutput productsStorage(@RequestBody ProductsStorageInput input){
        return productsService.productsStorage(input.getProductsStorageX1());
    }

    /**
     * 库存更新
     * @param input
     * @return
     */

    @PostMapping("/increase")
    public ProductsIncreaseOutput productsIncrease(@RequestBody ProductsIncreaseInput input){
        return productsService.productsIncrease(input.getProductsIncreaseX1List());
    }

    /**
     * 产品出库
     * @param input
     * @return
     */

    @PostMapping("/decrease")
    public ProductsDecreaseOutput productsDecrease(@RequestBody ProductsDecreaseInput input){
        return productsService.productsDecrease(input.getProductsDecreaseX1List());
    }
}
