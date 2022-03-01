package com.github.lvmt.lmtools.constructor.base;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 * 抽象的数据构造器
 * FR:最终wrapper build的结果，即构造器执行后返回的对象
 * R:构造器返回的结构
 * C:上下文参数
 */
public interface IDataConstructor<FR,
        C extends IDataConstructorContext,
        RW extends IDataConstructorResultWrapper<FR>> {

    void construct(RW wrapper, C ctx);

    default boolean accept(C ctx) {
        return true;
    }
}
