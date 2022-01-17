package com.jfl.pas2.controller;

import com.jfl.pas2.dto.product.ProductsDetailsInput;
import com.jfl.pas2.dto.product.ProductsDetailsOutput;
import com.jfl.pas2.dto.product.ProductsInfoInput;
import com.jfl.pas2.dto.product.ProductsInfoOutput;
import com.jfl.pas2.service.DetailService;
import com.jfl.pas2.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bin Liu
 * @date 2021-08-11-11:07 PM
 */

@RestController
@RequestMapping("/detail")
@ResponseBody
public class DetailController {

    @Autowired
    private DetailService detailService;

    /**
     * 产品信息查询
     * @param input
     * @return
     */

    @PostMapping("/query")
    public ProductsDetailsOutput detailQuery(@RequestBody ProductsDetailsInput input){
        return detailService.detailQuery(input.getProductsDetailsX1());
    }
}
