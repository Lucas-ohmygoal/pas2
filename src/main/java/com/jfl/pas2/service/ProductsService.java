package com.jfl.pas2.service;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.constant.param.Parameter;
import com.jfl.pas2.domain.Product;
import com.jfl.pas2.domain.User;
import com.jfl.pas2.dto.product.*;
import com.jfl.pas2.manager.DetailManager;
import com.jfl.pas2.manager.ProductsManager;
import com.jfl.pas2.manager.UserManager;
import io.netty.util.internal.StringUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-07-30-5:38 PM
 */

@Service
public class ProductsService {

    @Autowired
    private ProductsManager productsManager;
    @Autowired
    private MessageCodeService messageCodeService;
    @Autowired
    private UserManager userManager;
    @Autowired
    private DetailManager detailManager;


    /**
     * 登记产品信息
     * @param input
     */
    public ProductsRegisterOutput registerProducts(ProductsRegisterX1 input) throws JSONException, ParseException {
        //输入参数检查
        checkInputData(input);
        //生成产品编号
        String productId = getProductId(input.getProductCode());
        //登记产品信息
        productsManager.insertProductsInfo(productId, input);
        //发送短信通知
        User userInfo = userManager.queryAccountInfo(input.getUserId());
        messageCodeService.sendNotification(userInfo.getUserPhone(), productId);

        ProductsRegisterOutput output = new ProductsRegisterOutput();
        ProductsRegisterZ1 z1 = new ProductsRegisterZ1();
        z1.setProductModelId(productId);
        output.setProductsRegisterZ1(z1);
        return output;
    }

    /**
     * 产品信息查询
     * @param input
     * @return
     */
    public ProductsInfoOutput productsInfos(ProductsInfoX1 input){
        //数据检查
        queryDataCheck(input);
        //查询产品数据
        List<Product> productList = getProductsInfo(input);
        //接口赋值
        ProductsInfoOutput output = new ProductsInfoOutput();
        List<ProductsInfoZ1> productsInfoZ1s = new ArrayList<>();
        for(Product product: productList){
            ProductsInfoZ1 infoZ1 = queryDataValue(product);
            productsInfoZ1s.add(infoZ1);
        }
        output.setProductsInfoZ1s(productsInfoZ1s);
        return output;
    }

    /**
     * 产品库存查询
     * @param input
     * @return
     */
    public ProductsStorageOutput productsStorage(ProductsStorageX1 input){
        //产品代码
        if (StringUtil.isNullOrEmpty(input.getProductCode())){
            throw new AppException(ErrorEnum.E00029,"产品代码输入不可为空！");
        }
        //数量查询
        List<Product> productList = productsManager.queryProductsStorage(input);
        Iterator<Product> it = productList.iterator();
        while(it.hasNext()){
            Product product = it.next();
            if(!product.getProductModelId().substring(0,2).equals(input.getProductCode())){
                it.remove();
            }
        }
        BigDecimal result = new BigDecimal(0);
        for(Product product:productList){
            result = result.add(product.getProductStock());
        }
        //库存总量查询
        List<Product> grossList = productsManager.queryAllProductsInfos();
        Iterator<Product> all = grossList.iterator();
        while(all.hasNext()){
            Product product = all.next();
            if(!product.getProductModelId().substring(0,2).equals(input.getProductCode())){
                all.remove();
            }
        }
        BigDecimal gross = new BigDecimal(0);
        for(Product product:grossList){
            gross = gross.add(product.getProductStock());
        }


        ProductsStorageOutput output = new ProductsStorageOutput();
        ProductsStorageZ1 storageZ1 = new ProductsStorageZ1();
        storageZ1.setResult(result);
        storageZ1.setGross(gross);
        output.setProductsStorageZ1(storageZ1);
        return  output;
    }

    /**
     * 产品入库
     * @param inputList
     */
    public ProductsIncreaseOutput productsIncrease(List<ProductsIncreaseX1> inputList){
        //数据检查
        for(ProductsIncreaseX1 input:inputList){
            increaseDataCheck(input);
        }
        //更新产品数量
        for(ProductsIncreaseX1 input:inputList){
            productsManager.increaseProductsNumber(input);
        }

        //Todo 物料数量对应处理
        //写操作明细文件
        User userInfo = userManager.queryAccountInfo(inputList.get(0).getUserId());
        for(ProductsIncreaseX1 input:inputList) {
            detailManager.writeInputOperationDetails(input,userInfo.getUserName());
        }

        ProductsIncreaseOutput output = new ProductsIncreaseOutput();
        ProductsIncreaseZ1 productsIncreaseZ1 =new ProductsIncreaseZ1();
        output.setProductsIncreaseZ1(productsIncreaseZ1);
        return output;
    }

    /**
     * 产品出库
     * @param inputList
     */
    public ProductsDecreaseOutput productsDecrease(List<ProductsDecreaseX1> inputList){
        //数据检查
        for(ProductsDecreaseX1 input:inputList){
            decreaseDataCheck(input);
        }
        //更新产品数量
        for(ProductsDecreaseX1 input:inputList){
            productsManager.decreaseProductsNumber(input);
        }

        //Todo 物料数量对应处理
        //写操作明细文件
        User userInfo = userManager.queryAccountInfo(inputList.get(0).getUserId());
        for(ProductsDecreaseX1 input:inputList) {
            detailManager.writeOutputOperationDetails(input,userInfo.getUserName());
        }

        ProductsDecreaseOutput output = new ProductsDecreaseOutput();
        ProductsDecreaseZ1 productsDecreaseZ1 = new ProductsDecreaseZ1();
        output.setProductsDecreaseZ1(productsDecreaseZ1);
        return output;
    }

    /**
     * 登记产品信息-输入参数检查
     * @param input
     */
    public void checkInputData(ProductsRegisterX1 input){
        //用户号
        if (StringUtil.isNullOrEmpty(input.getUserId())){
            throw new AppException(ErrorEnum.E00027, "用户号不可为空");
        }
        //产品型号
        if(StringUtil.isNullOrEmpty(input.getProductType())){
            throw new AppException(ErrorEnum.E00016,"产品型号输入不可为空！");
        }
        //产品名称
        if(StringUtil.isNullOrEmpty(input.getProductName())){
            throw new AppException(ErrorEnum.E00017,"产品名称输入不可为空！");
        }
        //产品代码
        if (StringUtil.isNullOrEmpty(input.getProductCode())){
            throw new AppException(ErrorEnum.E00029,"产品代码输入不可为空！");
        }
        //品牌名称
        if(StringUtil.isNullOrEmpty(input.getProductBrand())){
            throw new AppException(ErrorEnum.E00018,"品牌名称输入不可为空！");
        }
        //产品尺寸
        if(StringUtil.isNullOrEmpty(input.getProductSize())){
            throw new AppException(ErrorEnum.E00019,"产品尺寸输入不可为空！");
        }
        //产品颜色
        if(StringUtil.isNullOrEmpty(input.getProductColor())){
            throw new AppException(ErrorEnum.E00020,"产品颜色输入不可为空！");
        }
        //叶片规格
        if(StringUtil.isNullOrEmpty(input.getProductBlade())){
            throw new AppException(ErrorEnum.E00021,"叶片规格输入不可为空！");
        }
        //电机规格
        if(StringUtil.isNullOrEmpty(input.getProductMotor())){
            throw new AppException(ErrorEnum.E00023,"电机规格输入不可为空！");
        }
        //成本价格
        if(input.getProductPrice().compareTo(BigDecimal.ZERO) <= 0){
            throw new AppException(ErrorEnum.E00024,"成本价格输入不合法！");
        }
    }

    /**
     * 登记产品信息-生成产品编号
     * @return
     */
    public String getProductId(String productCode){
        int newNumber = (int)((Math.random()*9+1)*100);
        String productId = productCode + newNumber;
        return productId;
    }

    /**
     * 产品信息查询-数据检查
     * @param input
     */
    public void queryDataCheck(ProductsInfoX1 input){
        //产品代码
        if (StringUtil.isNullOrEmpty(input.getProductCode())){
            throw new AppException(ErrorEnum.E00029,"产品代码输入不可为空！");
        }
        //查询条件
        if (StringUtil.isNullOrEmpty(input.getQueryCondition())){
            throw new AppException(ErrorEnum.E00030,"查询条件输入不可为空！");
        }
        //查询参数
        if (StringUtil.isNullOrEmpty(input.getQueryCondition())){
            throw new AppException(ErrorEnum.E00031,"查询参数输入不可为空！");
        }
    }

    /**
     * 产品信息查询-取产品数据
     * @param input
     * @return
     */
    public List<Product> getProductsInfo(ProductsInfoX1 input){
        List<Product> productList = new ArrayList<>();
        switch (input.getQueryCondition()){
            case "id": {
                productList = productsManager.queryProductsInfosByProductId(input.getQueryParam());
                break;
            }
            case "brands":{
                productList = productsManager.queryProductsInfosByBrands(input.getQueryParam());
                break;
            }
            case "sizes": {
                productList = productsManager.queryProductsInfosBySizes(input.getQueryParam());
                break;
            }
            case "types": {
                productList = productsManager.queryProductsInfosByTypes(input.getQueryParam());
                break;
            }
            case "colors": {
                productList = productsManager.queryProductsInfosByColors(input.getQueryParam());
                break;
            }
            case "all": {
                productList = productsManager.queryAllProductsInfos();
                break;
            }
            default:{

            }
        }

        Iterator<Product> it = productList.iterator();
        while(it.hasNext()){
            Product product = it.next();
            if(!product.getProductModelId().substring(0,2).equals(input.getProductCode())){
                it.remove();
            }
        }

        return productList;
    }

    /**
     * 产品信息查询-接口赋值
     * @param product
     * @return
     */
    public ProductsInfoZ1 queryDataValue(Product product){
        ProductsInfoZ1 productsInfoZ1 = new ProductsInfoZ1();
        productsInfoZ1.setProductModelId(product.getProductModelId());
        productsInfoZ1.setProductType(product.getProductType());
        productsInfoZ1.setProductBrand(product.getProductBrand());
        productsInfoZ1.setProductSize(product.getProductSize());
        productsInfoZ1.setProductBlade(product.getProductBlade());
        productsInfoZ1.setProductColor(product.getProductColor());
        productsInfoZ1.setProductMotor(product.getProductMotor());
        productsInfoZ1.setProductStock(product.getProductStock());
        productsInfoZ1.setSellingPrice(product.getProductPrice());
        return productsInfoZ1;
    }

    /**
     * 产品入库-入库数据检查
     * @param input
     */
    public void increaseDataCheck(ProductsIncreaseX1 input){

        if (StringUtil.isNullOrEmpty(input.getUserId())){
            throw new AppException(ErrorEnum.E00027, "用户号不可为空！");
        }
        if (StringUtil.isNullOrEmpty(input.getOperationSeries())){
            throw new AppException(ErrorEnum.E00040,"入库单号输入不可为空！");
        }
        if (StringUtil.isNullOrEmpty(input.getProductId())){
            throw new AppException(ErrorEnum.E00025,"产品编号不可为空！");
        }
        if (input.getNumber().compareTo(BigDecimal.ZERO)<= 0){
            throw new AppException(ErrorEnum.E00033,"产品数量不可为空！");
        }
        if (!input.getWithCups().equals(Parameter.IS_WITH_CUPS) && !input.getWithCups().equals(Parameter.NOT_WITH_CUPS)){
            throw new AppException(ErrorEnum.E00033,"请确认是否带有风杯");
        }
        if (!input.getWithSwitches().equals(Parameter.IS_WITH_SWITCHES) && !input.getWithSwitches().equals(Parameter.NOT_WITH_SWITCHES)){
            throw new AppException(ErrorEnum.E00034,"请确认是否带有调速器");
        }
        if (!input.getWithCircles().equals(Parameter.IS_WITH_CIRCLES) && !input.getWithCircles().equals(Parameter.NOT_WITH_CIRCLES)){
            throw new AppException(ErrorEnum.E00035,"请确认是否带有中环");
        }

        List<Product> productList=productsManager.queryProductsInfosById(input.getProductId());
        if (productList.isEmpty()){
            throw new AppException(ErrorEnum.E00038, "出现产品编号不存在，请认真核对！");
        }
    }

    /**
     * 产品出库-出库数据检查
     * @param input
     */
    public void decreaseDataCheck(ProductsDecreaseX1 input){

        if (StringUtil.isNullOrEmpty(input.getUserId())){
            throw new AppException(ErrorEnum.E00027, "用户号不可为空！");
        }
        if (StringUtil.isNullOrEmpty(input.getOperationSeries())){
            throw new AppException(ErrorEnum.E00042,"出库单号输入不可为空！");
        }
        if (StringUtil.isNullOrEmpty(input.getProductId())){
            throw new AppException(ErrorEnum.E00025,"产品编号不可为空！");
        }
        if (input.getNumber().compareTo(BigDecimal.ZERO)<= 0){
            throw new AppException(ErrorEnum.E00033,"产品数量不可为空！");
        }
        if (!input.getWithCups().equals(Parameter.IS_WITH_CUPS) && !input.getWithCups().equals(Parameter.NOT_WITH_CUPS)){
            throw new AppException(ErrorEnum.E00033,"请确认是否带有风杯");
        }
        if (!input.getWithSwitches().equals(Parameter.IS_WITH_SWITCHES) && !input.getWithSwitches().equals(Parameter.NOT_WITH_SWITCHES)){
            throw new AppException(ErrorEnum.E00034,"请确认是否带有调速器");
        }
        if (!input.getWithCircles().equals(Parameter.IS_WITH_CIRCLES) && !input.getWithCircles().equals(Parameter.NOT_WITH_CIRCLES)){
            throw new AppException(ErrorEnum.E00035,"请确认是否带有中环");
        }
        input.setNumber(input.getNumber().negate());
        List<Product> productList=productsManager.queryProductsInfosById(input.getProductId());
        if (productList.isEmpty()){
            throw new AppException(ErrorEnum.E00038,"出现产品编号不存在，请认真核对！");
        }
    }
}
