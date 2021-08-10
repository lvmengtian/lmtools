package com.github.lvmt.lmtools.provider.profile.provider;

import java.util.Collection;
import java.util.List;

import com.github.lvmt.lmtools.provider.IProvider;
import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.model.ProfileModel;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;

import sun.java2d.cmm.Profile;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
public abstract class AbstractProfileProvider
        implements IProvider<Collection<ProfileProviderResultWrapper>, MultiProfileProviderResultWrapper, ProfileProviderContext> {
}
