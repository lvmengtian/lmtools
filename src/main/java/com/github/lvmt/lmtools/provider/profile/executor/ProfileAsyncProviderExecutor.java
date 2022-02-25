package com.github.lvmt.lmtools.provider.profile.executor;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
 * Created on 2021-08-11
 */
@Service
@Data
public class ProfileAsyncProviderExecutor extends AbstractProfileProviderExecutor {
    @Autowired
    private List<AbstractProfileProvider> profileProviders;
    // 执行profile的各个provider
    private List<AbstractProfileProvider> executors;

    @PostConstruct
    public void init() {
        this.setExecutors(profileProviders);
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    public List<ProfileModel> executor(ProfileProviderContext context) {
        MultiProfileProviderResultWrapper resultWrapper = new MultiProfileProviderResultWrapper();
        resultWrapper.makeSafe();

        CountDownLatch countDownLatch = new CountDownLatch(executors.size());
        for (AbstractProfileProvider provider : executors) {
            executorService.submit(() -> {
                try {
                    provider.provider(resultWrapper, context);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        // todo 可以指定超时时间
        try {
            countDownLatch.await();
        } catch (Exception e) {
            // 异常处理
        }
        return resultWrapper.build().stream().map(ProfileProviderResultWrapper::build).collect(Collectors.toList());
    }

}
