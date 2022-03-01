package com.github.lvmt.lmtools.constructor.demo.constructor;

import com.github.lvmt.lmtools.constructor.demo.model.ProductInfo;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public class ProductInfoDataConstructor implements IProductDetailsPageDataConstructor {
    @Override
    public void construct(ProductDetailsPageResultWrapper wrapper, ProductDetailsPageDataConstructorContext ctx) {
        wrapper.setProductInfo(ProductInfo.mockProductInfo());
    }
}
