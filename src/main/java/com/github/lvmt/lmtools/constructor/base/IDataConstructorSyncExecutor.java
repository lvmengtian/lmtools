package com.github.lvmt.lmtools.constructor.base;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-03-01
 */
public interface IDataConstructorSyncExecutor
        <FR, CTX extends IDataConstructorContext, RW extends IDataConstructorResultWrapper<FR>>
        extends IDataConstructorExecutor<FR, CTX, RW> {

    @Override
    default FR executor(RW wrapper, CTX ctx, List<? extends IDataConstructor<FR, CTX, RW>> constructorList) {
        for (IDataConstructor<FR, CTX, RW> constructor : constructorList) {
            if (constructor.accept(ctx)) {
                constructor.construct(wrapper, ctx);
            }
        }
        return wrapper.build();
    }
}
