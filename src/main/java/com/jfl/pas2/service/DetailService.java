package com.jfl.pas2.service;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.domain.Detail;
import com.jfl.pas2.domain.Product;
import com.jfl.pas2.dto.product.ProductsDetailsOutput;
import com.jfl.pas2.dto.product.ProductsDetailsX1;
import com.jfl.pas2.dto.product.ProductsDetailsZ1;
import com.jfl.pas2.manager.DetailManager;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-08-11-11:09 PM
 */

@Service
public class DetailService {

    @Autowired
    private DetailManager detailManager;

    /**
     * 查询操作明细
     * @param input
     * @return
     */
    public ProductsDetailsOutput detailQuery(ProductsDetailsX1 input){
        //日期检查
        dateCheck(input);
        //查询操作明细
        List<Detail> detailList = detailManager.queryOperationDetail(input.getStartDate(), input.getEndDate());
        //接口赋值
        Iterator<Detail> all = detailList.iterator();
        while(all.hasNext()){
            Detail detail = all.next();
            if(!detail.getProductId().substring(0,2).equals(input.getProductCode())){
                all.remove();
            }
        }
        List<ProductsDetailsZ1> productsDetailsZ1s = new ArrayList<>();
        for(Detail detail: detailList){
            ProductsDetailsZ1 productsDetailsZ1 = new ProductsDetailsZ1();
            wrapOutput(productsDetailsZ1,detail);
            productsDetailsZ1s.add(productsDetailsZ1);
        }

        ProductsDetailsOutput output = new ProductsDetailsOutput();
        output.setProductsDetailsZ1List(productsDetailsZ1s);
        return output;
    }

    /**
     * 查询操作明细-日期检查
     * @param input
     */
    public void dateCheck(ProductsDetailsX1 input){
        Integer startDate = Integer.valueOf(input.getStartDate());
        Integer endDate = Integer.valueOf(input.getEndDate());
        if (startDate > endDate){
            throw new AppException(ErrorEnum.E00043, "开始日期不可大于结束日期！");
        }
        //产品代码
        if (StringUtil.isNullOrEmpty(input.getProductCode())){
            throw new AppException(ErrorEnum.E00029,"产品代码输入不可为空！");
        }
    }

    /**
     * 查询操作明细-接口赋值
     * @param detail
     */
    public void wrapOutput(ProductsDetailsZ1 productsDetailsZ1,Detail detail){
        productsDetailsZ1.setProductId(detail.getProductId());
        productsDetailsZ1.setProductIncrement(detail.getProductNumber());
        productsDetailsZ1.setWithCups(detail.getWithCups());
        productsDetailsZ1.setWithSwitches(detail.getWithSwitches());
        productsDetailsZ1.setWithCircles(detail.getWithCircles());
        productsDetailsZ1.setOperationName(detail.getOperatorName());
        productsDetailsZ1.setOperationDate(detail.getOperationDate());
        productsDetailsZ1.setOperationTime(detail.getOperationTime());
        productsDetailsZ1.setOperationSeries(detail.getSerialNumber());
    }
}
