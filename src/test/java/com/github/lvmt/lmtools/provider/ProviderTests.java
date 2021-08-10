package com.github.lvmt.lmtools.provider;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.executor.ProfileProviderExecutor;
import com.github.lvmt.lmtools.provider.profile.model.ProfileModel;
import com.github.lvmt.lmtools.provider.profile.provider.AbstractProfileProvider;
import com.google.common.collect.Lists;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
@SpringBootTest
public class ProviderTests {
    @Autowired
    private ProfileProviderExecutor profileProviderExecutor;

    @Test
    public void testProfileProvider() {
        ProfileProviderContext ctx = new ProfileProviderContext();
        ctx.setSellerIdList(Lists.newArrayList(12323L, 34344L));
        List<ProfileModel> profileModels = profileProviderExecutor.executor(ctx);
        profileModels.forEach(System.out::println);
    }
}
