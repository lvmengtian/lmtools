package com.github.lvmt.lmtools.constructor.demo.model;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 * 商详页对象
 */
public class ProductDetailsPage {
    // 商品信息 - 通过商品中心读取
    private ProductInfo productInfo;

    // 营销信息 - 通过营销中心读取
    private MarketingInfo marketingInfo;

    // 评论信息 - 通过评论中心读取
    private CommentInfo commentInfo;

    public ProductDetailsPage() {
    }

    public ProductDetailsPage(ProductInfo productInfo, MarketingInfo marketingInfo, CommentInfo commentInfo) {
        this.productInfo = productInfo;
        this.marketingInfo = marketingInfo;
        this.commentInfo = commentInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public MarketingInfo getMarketingInfo() {
        return marketingInfo;
    }

    public void setMarketingInfo(MarketingInfo marketingInfo) {
        this.marketingInfo = marketingInfo;
    }

    public CommentInfo getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(CommentInfo commentInfo) {
        this.commentInfo = commentInfo;
    }

    @Override
    public String toString() {
        return "ProductDetailsPage{" +
                "productInfo=" + productInfo +
                ", marketingInfo=" + marketingInfo +
                ", commentInfo=" + commentInfo +
                '}';
    }
}
