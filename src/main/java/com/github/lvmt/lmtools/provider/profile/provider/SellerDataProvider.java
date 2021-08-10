package com.github.lvmt.lmtools.provider.profile.provider;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-10
 */
@Service
public class SellerDataProvider extends AbstractProfileProvider {

    @Override
    public void provider(MultiProfileProviderResultWrapper resultWrapper, ProfileProviderContext ctx) {
        // 处理多个sellerId的情况
        ctx.getSellerIdList().forEach(sellerId -> {
            Map<Long, ProfileProviderResultWrapper> map = resultWrapper.getResultWrapperMap();
            ProfileProviderResultWrapper wrapper = map.getOrDefault(sellerId, new ProfileProviderResultWrapper());
            wrapper.setLiveCnt(10023L);
            wrapper.setSaleAmt(1233434L);
            wrapper.setNewFollowerCnt(10001L);
            map.put(sellerId, wrapper);
        });
    }
}
