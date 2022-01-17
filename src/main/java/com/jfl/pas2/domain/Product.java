package com.jfl.pas2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_model_id
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productModelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_type
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_name
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_brand
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productBrand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_size
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_color
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productColor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_blade
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productBlade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_pillar
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productPillar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_motor
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productMotor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_cup
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productCup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_switch
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String productSwitch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_stock
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private BigDecimal productStock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.product_price
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private BigDecimal productPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.update_user
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.update_date
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.update_time
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private String updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table product
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_model_id
     *
     * @return the value of product.product_model_id
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductModelId() {
        return productModelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_model_id
     *
     * @param productModelId the value for product.product_model_id
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId == null ? null : productModelId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_type
     *
     * @return the value of product.product_type
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductType() {
        return productType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_type
     *
     * @param productType the value for product.product_type
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_name
     *
     * @return the value of product.product_name
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_name
     *
     * @param productName the value for product.product_name
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_brand
     *
     * @return the value of product.product_brand
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_brand
     *
     * @param productBrand the value for product.product_brand
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_size
     *
     * @return the value of product.product_size
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductSize() {
        return productSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_size
     *
     * @param productSize the value for product.product_size
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_color
     *
     * @return the value of product.product_color
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductColor() {
        return productColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_color
     *
     * @param productColor the value for product.product_color
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductColor(String productColor) {
        this.productColor = productColor == null ? null : productColor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_blade
     *
     * @return the value of product.product_blade
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductBlade() {
        return productBlade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_blade
     *
     * @param productBlade the value for product.product_blade
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductBlade(String productBlade) {
        this.productBlade = productBlade == null ? null : productBlade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_pillar
     *
     * @return the value of product.product_pillar
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductPillar() {
        return productPillar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_pillar
     *
     * @param productPillar the value for product.product_pillar
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductPillar(String productPillar) {
        this.productPillar = productPillar == null ? null : productPillar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_motor
     *
     * @return the value of product.product_motor
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductMotor() {
        return productMotor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_motor
     *
     * @param productMotor the value for product.product_motor
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductMotor(String productMotor) {
        this.productMotor = productMotor == null ? null : productMotor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_cup
     *
     * @return the value of product.product_cup
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductCup() {
        return productCup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_cup
     *
     * @param productCup the value for product.product_cup
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductCup(String productCup) {
        this.productCup = productCup == null ? null : productCup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_switch
     *
     * @return the value of product.product_switch
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getProductSwitch() {
        return productSwitch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_switch
     *
     * @param productSwitch the value for product.product_switch
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductSwitch(String productSwitch) {
        this.productSwitch = productSwitch == null ? null : productSwitch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_stock
     *
     * @return the value of product.product_stock
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public BigDecimal getProductStock() {
        return productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_stock
     *
     * @param productStock the value for product.product_stock
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductStock(BigDecimal productStock) {
        this.productStock = productStock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.product_price
     *
     * @return the value of product.product_price
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.product_price
     *
     * @param productPrice the value for product.product_price
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.update_user
     *
     * @return the value of product.update_user
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.update_user
     *
     * @param updateUser the value for product.update_user
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.update_date
     *
     * @return the value of product.update_date
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.update_date
     *
     * @param updateDate the value for product.update_date
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.update_time
     *
     * @return the value of product.update_time
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.update_time
     *
     * @param updateTime the value for product.update_time
     *
     * @mbggenerated Fri Jul 30 21:01:06 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}