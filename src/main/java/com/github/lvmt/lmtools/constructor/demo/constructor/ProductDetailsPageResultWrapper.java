package com.github.lvmt.lmtools.constructor.demo.constructor;

import com.github.lvmt.lmtools.constructor.base.IDataConstructorResultWrapper;
import com.github.lvmt.lmtools.constructor.demo.model.CommentInfo;
import com.github.lvmt.lmtools.constructor.demo.model.MarketingInfo;
import com.github.lvmt.lmtools.constructor.demo.model.ProductDetailsPage;
import com.github.lvmt.lmtools.constructor.demo.model.ProductInfo;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public class ProductDetailsPageResultWrapper implements IDataConstructorResultWrapper<ProductDetailsPage> {
    private ProductInfo productInfo;
    private MarketingInfo marketingInfo;
    private CommentInfo commentInfo;

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
    public ProductDetailsPage build() {
        return new ProductDetailsPage(productInfo, marketingInfo, commentInfo);
    }
}
