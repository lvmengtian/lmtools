package com.github.lvmt.lmtools.constructor.demo.constructor;

import java.util.ArrayList;
import java.util.List;

import com.github.lvmt.lmtools.constructor.base.IDataConstructorASyncExecutor;
import com.github.lvmt.lmtools.constructor.base.IDataConstructorSyncExecutor;
import com.github.lvmt.lmtools.constructor.demo.model.ProductDetailsPage;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public class ProductDetailsPageDataConstructorExecutor
        implements IDataConstructorASyncExecutor<
                ProductDetailsPage,
                ProductDetailsPageDataConstructorContext,
                ProductDetailsPageResultWrapper> {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<IProductDetailsPageDataConstructor> constructorList = new ArrayList<>();
        constructorList.add(new CommentInfoDataConstructor());
        constructorList.add(new MarketingInfoDataConstructor());
        constructorList.add(new ProductInfoDataConstructor());

        ProductDetailsPageResultWrapper wrapper = new ProductDetailsPageResultWrapper();

        ProductDetailsPage page = new ProductDetailsPageDataConstructorExecutor()
                .executor(wrapper, null, constructorList);

        long cost = System.currentTimeMillis() - startTime;

        System.out.println(page);
        System.out.println("cost:" + cost);

    }

}
