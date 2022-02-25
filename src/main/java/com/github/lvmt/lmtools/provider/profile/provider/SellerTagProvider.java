package com.github.lvmt.lmtools.provider.profile.provider;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;
import com.google.common.collect.Lists;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
@Service
public class SellerTagProvider extends AbstractProfileProvider {

    @Override
    public void providerDirectly(MultiProfileProviderResultWrapper resultWrapper, ProfileProviderContext ctx) {
        // 处理多个sellerId的情况
        int i = 0;
        for (long sellerId : ctx.getSellerIdList()) {
            List<String> sellerTags = Lists.newArrayList("卖货达人" + i, "海淀区销量第" + i);
            Map<Long, ProfileProviderResultWrapper> map = resultWrapper.getResultWrapperMap();
            ProfileProviderResultWrapper wrapper = map.getOrDefault(sellerId, new ProfileProviderResultWrapper());
            wrapper.setSellerTags(sellerTags);
            map.put(sellerId, wrapper);
            i++;
        }
    }
}
