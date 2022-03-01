package com.github.lvmt.lmtools.constructor.base;

import java.util.List;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 * 构造器的执行器
 * FR: wrapper build的结果
 * R: 构造器返回的结果
 * C：参数
 * RW：结果包装类
 */
public interface IDataConstructorExecutor<
        FR,
        CTX extends IDataConstructorContext,
        RW extends IDataConstructorResultWrapper<FR>> {

    FR executor(RW wrapper, CTX ctx, List<? extends IDataConstructor<FR, CTX, RW>> constructorList);
}
