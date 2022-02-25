package com.github.lvmt.lmtools.provider.profile.provider;

import java.util.Collection;

import com.github.lvmt.lmtools.provider.IProvider;
import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
public abstract class AbstractProfileProvider
        implements IProvider<ProfileProviderContext, Collection<ProfileProviderResultWrapper>, MultiProfileProviderResultWrapper> {
}
