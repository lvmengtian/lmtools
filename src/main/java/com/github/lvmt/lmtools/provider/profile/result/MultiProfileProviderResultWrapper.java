package com.github.lvmt.lmtools.provider.profile.result;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.lvmt.lmtools.provider.IProviderResultWrapper;

import lombok.Data;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
@Data
public class MultiProfileProviderResultWrapper implements IProviderResultWrapper<Collection<ProfileProviderResultWrapper>> {
    Map<Long, ProfileProviderResultWrapper> resultWrapperMap = new HashMap<>();

    @Override
    public Collection<ProfileProviderResultWrapper> build() {
        return resultWrapperMap.values();
    }

    @Override
    public void makeSafe() {
        resultWrapperMap = new ConcurrentHashMap<>();
    }
}
