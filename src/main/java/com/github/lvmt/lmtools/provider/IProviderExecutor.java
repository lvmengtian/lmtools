package com.github.lvmt.lmtools.provider;

import com.github.lvmt.lmtools.provider.IProviderContext;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 * 通用查数据的处理器，内部调用IProvider
 */
public interface IProviderExecutor<Request extends IProviderContext, Response> {
    Response executor(Request context);
}
