package com.github.lvmt.lmtools.provider;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 * 查询结果包装类
 */
public interface IProviderResultWrapper<R> {
    public R build();
}
