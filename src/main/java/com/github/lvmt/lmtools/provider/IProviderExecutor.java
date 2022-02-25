package com.github.lvmt.lmtools.provider;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 * 通用查数据的处理器，内部调用IProvider
 */
public interface IProviderExecutor<Context extends IProviderContext, Response> {
    Response executor(Context context);
}
