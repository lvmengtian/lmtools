package com.github.lvmt.lmtools.constructor.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 * 商品信息
 */
public class ProductInfo {
    // 加密的商品id
    private String productId;
    // 商品名
    private String productName;
    // 商品图片列表
    private List<String> productImgs;
    // 商品价格（多sku则是价格最低的sku价格）
    private long productPrice;
    // 商品库存（sku库存之和）
    private long productStock;
    // 商品描述信息
    private String productDesc;

    public static ProductInfo mockProductInfo() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("FR3zdj_s3");
        productInfo.setProductName("鸿星尔克跑鞋");

        List<String> productImgs = new ArrayList<>();
        productImgs.add("http://43.243.128.175/admin/upload/goods/51116320147/20170523140623-5--w_200_h_200.jpg");
        productImgs.add("http://43.243.128.175/admin/upload/goods/51117120110/20170626165858-51117120110-103-1--w_200_h_200.jpg");
        productInfo.setProductImgs(productImgs);

        productInfo.setProductPrice(145000);
        productInfo.setProductStock(999);
        productInfo.setProductDesc("鸿星尔克TO BE NUMBER ONE");

        // 模拟下游请求耗时
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return productInfo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getProductImgs() {
        return productImgs;
    }

    public void setProductImgs(List<String> productImgs) {
        this.productImgs = productImgs;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public long getProductStock() {
        return productStock;
    }

    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productImgs=" + productImgs +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
