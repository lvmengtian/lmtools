package com.github.lvmt.lmtools.constructor.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

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
        //service.buildBySerial();
        service.buildByConcurrent();
    }
    /**
     * 串行读取
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
        System.out.println("cost:" + cost + "ms");
        return productDetailsPage;
    }

    /**
     * 并行读取
     */
    public ProductDetailsPage buildByConcurrent() {
        try {
            long startTime = System.currentTimeMillis();
            // 定义线程池
            ExecutorService executor = Executors.newFixedThreadPool(5);

            Future<ProductInfo> productInfoFuture = executor.submit(ProductInfo::mockProductInfo);
            Future<MarketingInfo> marketingInfoFuture = executor.submit(MarketingInfo::mockMarketingInfo);
            Future<CommentInfo> commentInfoFuture = executor.submit(CommentInfo::mockCommentInfo);

            ProductDetailsPage productDetailsPage = new ProductDetailsPage(productInfoFuture.get(), marketingInfoFuture.get(), commentInfoFuture.get());
            // 耗时
            long cost = System.currentTimeMillis() - startTime;
            System.out.println("cost: " + cost);
            return productDetailsPage;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;
    }
}
