package com.jfl.pas2.manager;

import com.jfl.pas2.application.AppException;
import com.jfl.pas2.constant.error.ErrorEnum;
import com.jfl.pas2.constant.param.Parameter;
import com.jfl.pas2.domain.Product;
import com.jfl.pas2.domain.ProductExample;
import com.jfl.pas2.dto.product.ProductsDecreaseX1;
import com.jfl.pas2.dto.product.ProductsIncreaseX1;
import com.jfl.pas2.dto.product.ProductsRegisterX1;
import com.jfl.pas2.dto.product.ProductsStorageX1;
import com.jfl.pas2.mapper.ProductMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Bin Liu
 * @date 2021-07-31-10:02 AM
 */

@Component
public class ProductsManager {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 产品信息登记
     *
     * @param productId
     * @param input
     */

    public void insertProductsInfo(String productId, ProductsRegisterX1 input) {
        //产品编号
        if (StringUtil.isNullOrEmpty(productId)) {
            throw new AppException(ErrorEnum.E00025, "产品编号不可为空");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Product product = new Product();
        product.setProductModelId(productId);
        product.setProductType(input.getProductType());
        product.setProductName(input.getProductName());
        product.setProductBrand(input.getProductBrand());
        product.setProductSize(input.getProductSize());
        product.setProductColor(input.getProductColor());
        product.setProductBlade(input.getProductBlade());
        product.setProductPillar(input.getProductPillar());
        product.setProductMotor(input.getProductMotor());
        product.setProductCup(input.getProductCup());
        product.setProductPrice(input.getProductPrice());
        product.setProductSwitch(input.getProductSwitch());
        product.setProductStock(BigDecimal.ZERO);
        product.setUpdateUser(input.getUserId());
        product.setUpdateDate(date.substring(0, 8));
        product.setUpdateTime(date.substring(8, 14));

        if (productMapper.insertSelective(product) < 0) {
            throw new AppException(ErrorEnum.E00026, "写产品信息文件出错！");
        }

    }

    /**
     * 根据id查产品信息
     *
     * @param productId
     * @return
     */
    public List<Product> queryProductsInfosById(String productId) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductModelIdEqualTo(productId);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 根据品牌查产品信息
     *
     * @param brand
     * @return
     */
    public List<Product> queryProductsInfosByBrands(String brand) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductBrandEqualTo(brand);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 根据尺寸查产品信息
     *
     * @param size
     * @return
     */
    public List<Product> queryProductsInfosBySizes(String size) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductSizeEqualTo(size);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 根据型号查产品信息
     *
     * @param type
     * @return
     */
    public List<Product> queryProductsInfosByTypes(String type) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductTypeEqualTo(type);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 根据颜色查产品信息
     *
     * @param color
     * @return
     */
    public List<Product> queryProductsInfosByColors(String color) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductColorEqualTo(color);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 根据型号查产品信息
     *
     * @param productId
     * @return
     */
    public List<Product> queryProductsInfosByProductId(String productId) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductModelIdEqualTo(productId);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 查全部产品信息
     *
     * @param
     * @return
     */
    public List<Product> queryAllProductsInfos() {
        ProductExample example = new ProductExample();
        example.createCriteria();
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 查询产品数量
     *
     * @param
     * @return
     */
    public List<Product> queryProductsStorage(ProductsStorageX1 input) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria cri = example.createCriteria();
        if (!input.getProductTypes().isEmpty()) {
            cri.andProductTypeIn(input.getProductTypes());
        }
        if (input.getProductBrands() != null && !input.getProductBrands().isEmpty()) {
            cri.andProductBrandIn(input.getProductBrands());
        }
        if (input.getProductSizes() != null && !input.getProductSizes().isEmpty()) {
            cri.andProductSizeIn(input.getProductSizes());
        }
        if (input.getProductColors() != null && !input.getProductColors().isEmpty()) {
            cri.andProductColorIn(input.getProductColors());
        }
        if (input.getProductBlades() != null && !input.getProductBlades().isEmpty()) {
            cri.andProductBladeIn(input.getProductBlades());
        }
        if (input.getProductMotors() != null && !input.getProductMotors().isEmpty()) {
            cri.andProductMotorIn(input.getProductMotors());
        }
        List<Product> productList = productMapper.selectByExample(example);
        if (productList == null) {
            throw new AppException(ErrorEnum.E00032, "查询产品信息文件出错！");
        }
        return productList;
    }

    /**
     * 产品入库
     *
     * @param input
     */
    public void increaseProductsNumber(ProductsIncreaseX1 input) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Product product = productMapper.selectByPrimaryKey(input.getProductId());
        product.setProductStock(product.getProductStock().add(input.getNumber()));
        product.setUpdateUser(input.getUserId());
        product.setUpdateDate(date.substring(0, 8));
        product.setUpdateTime(date.substring(8, 14));

        if (productMapper.updateByPrimaryKey(product) < 0) {
            throw new AppException(ErrorEnum.E00037, "更新产品信息文件出错！");
        }
    }

    /**
     * 产品出库
     *
     * @param input
     */
    public void decreaseProductsNumber(ProductsDecreaseX1 input) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Product product = productMapper.selectByPrimaryKey(input.getProductId());
        if (product.getProductStock().compareTo(input.getNumber()) < 0) {
            throw new AppException(ErrorEnum.E00039, "出现产品库存不足！");
        }
        product.setProductStock(product.getProductStock().subtract(input.getNumber()));
        product.setUpdateUser(input.getUserId());
        product.setUpdateDate(date.substring(0,8));
        product.setUpdateTime(date.substring(8,14));

        if(productMapper.updateByPrimaryKey(product) < 0){
            throw new AppException(ErrorEnum.E00037, "更新产品信息文件出错！");
        }
    }
}
