package com.github.lvmt.lmtools.provider;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 *
 * 数据处理提供者，通过IProviderExecutor执行
 */
public interface IProvider<R, ResultWrapper extends IProviderResultWrapper<R>, Context extends IProviderContext> {

    /**
     * 数据提供方法
     */
    void provider(ResultWrapper resultWrapper, Context ctx);
}
