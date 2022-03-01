package com.github.lvmt.lmtools.constructor.demo.service;

import com.github.lvmt.lmtools.constructor.demo.model.CommentInfo;
import com.github.lvmt.lmtools.constructor.demo.model.MarketingInfo;
import com.github.lvmt.lmtools.constructor.demo.model.ProductDetailsPage;
import com.github.lvmt.lmtools.constructor.demo.model.ProductInfo;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 */
public class ProductDetailsPageService {

    public static void main(String[] args) {
        ProductDetailsPageService service = new ProductDetailsPageService();
        service.buildBySerial();
    }
    /**
     * 串行读取
     * @return
     */
    public ProductDetailsPage buildBySerial() {
        long startTime = System.currentTimeMillis();
        // 读取商品信息
        ProductInfo productInfo = ProductInfo.mockProductInfo();
        // 读取营销信息
        MarketingInfo marketingInfo = MarketingInfo.mockMarketingInfo();
        // 读取评论信息
        CommentInfo commentInfo = CommentInfo.mockCommentInfo();
        // 耗时
        long cost = System.currentTimeMillis() - startTime;
        // 赋值返回
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(productInfo, marketingInfo, commentInfo);
        System.out.println("productDetailsPage: " + productDetailsPage.toString());
        System.out.println("cost:" + cost + "ms");
        return productDetailsPage;
    }
}
