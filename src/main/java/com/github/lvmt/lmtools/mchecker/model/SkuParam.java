package com.github.lvmt.lmtools.mchecker.model;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-24
 * 示例对象---Sku参数
 */
public class SkuParam {
    private String skuName;
    private long skuPrice;
    private long skuStock;

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public long getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(long skuPrice) {
        this.skuPrice = skuPrice;
    }

    public long getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(long skuStock) {
        this.skuStock = skuStock;
    }

    public SkuParam(String skuName, long skuPrice, long skuStock) {
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.skuStock = skuStock;
    }

    public static SkuParam build1() {
        return new SkuParam("小黄鸭图案", 200L, 90L);
    }

    public static SkuParam build2() {
        return new SkuParam("哆啦A梦图案", 9L, 1000L);
    }

}
