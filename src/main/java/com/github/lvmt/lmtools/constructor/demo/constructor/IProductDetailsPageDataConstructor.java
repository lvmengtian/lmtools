package com.github.lvmt.lmtools.constructor.demo.constructor;

import com.github.lvmt.lmtools.constructor.base.IDataConstructor;
import com.github.lvmt.lmtools.constructor.demo.model.ProductDetailsPage;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public interface IProductDetailsPageDataConstructor extends IDataConstructor<
        ProductDetailsPage,
        ProductDetailsPageDataConstructorContext,
        ProductDetailsPageResultWrapper> {
}
