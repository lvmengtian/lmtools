package com.github.lvmt.lmtools.provider;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 *
 * 数据处理提供者，通过IProviderExecutor执行
 */
public interface IProvider<Context extends IProviderContext, FinalResult, ResultWrapper extends IProviderResultWrapper<FinalResult>> {

    /**
     * 是否执行provider方法，默认true
     * @return
     */
    default boolean shouldProvider() {
        return true;
    }

    default void provider(ResultWrapper resultWrapper, Context ctx) {
        if (shouldProvider()) {
            providerDirectly(resultWrapper, ctx);
        }
    }

    /**
     * 数据提供方法
     */
    void providerDirectly(ResultWrapper resultWrapper, Context ctx);
}
