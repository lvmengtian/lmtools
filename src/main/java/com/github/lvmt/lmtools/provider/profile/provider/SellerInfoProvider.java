package com.github.lvmt.lmtools.provider.profile.provider;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 *
 * 商家基本信息查询器
 */
@Service
public class SellerInfoProvider extends AbstractProfileProvider {

    @Override
    public void providerDirectly(MultiProfileProviderResultWrapper resultWrapper, ProfileProviderContext ctx) {
        // 处理多个sellerId的情况
        int i = 0;
        for (long sellerId : ctx.getSellerIdList()) {
            Map<Long, ProfileProviderResultWrapper> map = resultWrapper.getResultWrapperMap();
            ProfileProviderResultWrapper wrapper = map.getOrDefault(sellerId, new ProfileProviderResultWrapper());
            wrapper.setSellerId(sellerId);
            wrapper.setSellerName("是小毛吖" + i);
            wrapper.setSellerAvatar("http://img.com" + i);
            map.put(sellerId, wrapper);
            i++;
        }
    }
}
