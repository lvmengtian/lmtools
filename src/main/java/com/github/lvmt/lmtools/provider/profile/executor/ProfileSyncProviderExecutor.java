package com.github.lvmt.lmtools.provider.profile.executor;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lvmt.lmtools.provider.profile.context.ProfileProviderContext;
import com.github.lvmt.lmtools.provider.profile.model.ProfileModel;
import com.github.lvmt.lmtools.provider.profile.provider.AbstractProfileProvider;
import com.github.lvmt.lmtools.provider.profile.result.MultiProfileProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.result.ProfileProviderResultWrapper;

import lombok.Data;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 */
@Data
@Service
public class ProfileSyncProviderExecutor extends AbstractProfileProviderExecutor {
    @Autowired
    private List<AbstractProfileProvider> profileProviders;
    // 执行profile的各个provider
    private List<AbstractProfileProvider> executors;

    @PostConstruct
    public void init() {
        this.setExecutors(profileProviders);
    }
    @Override
    public List<ProfileModel> executor(ProfileProviderContext context) {
        MultiProfileProviderResultWrapper resultWrapper = new MultiProfileProviderResultWrapper();
        for (AbstractProfileProvider provider : executors) {
            provider.provider(resultWrapper, context);
        }
        return resultWrapper.build().stream().map(ProfileProviderResultWrapper::build).collect(Collectors.toList());
    }
}
