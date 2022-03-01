package com.github.lvmt.lmtools.constructor.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public interface IDataConstructorASyncExecutor
        <FR, CTX extends IDataConstructorContext, RW extends IDataConstructorResultWrapper<FR>>
        extends IDataConstructorExecutor<FR, CTX, RW> {

    // 定义线程池
    ExecutorService executor = Executors.newFixedThreadPool(5);

    @Override
    default FR executor(RW wrapper, CTX ctx, List<? extends IDataConstructor<FR, CTX, RW>> constructorList) {
        try {
            List<Future> futureList = new ArrayList<>();
            for (IDataConstructor<FR, CTX, RW> constructor : constructorList) {
                futureList.add(executor.submit(() -> constructor.construct(wrapper, ctx)));
            }
            for (Future future : futureList) {
                future.get();
            }
            return wrapper.build();
        } catch (Exception e) {
            return null;
        }

    }

}
