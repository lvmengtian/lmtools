package com.github.lvmt.lmtools;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-06-09
 */
public class RetryUtil {
    // 默认最大重试次数
    private static final int DEFAULT_MAX_RETRY_COUNT = 3;
    // 默认单次重试等待时间
    private static final long DEFAULT_RETRY_WAIT_TIME_MILLIS = 100L;

    private static final Logger LOG = LoggerFactory.getLogger(RetryUtil.class);

    public static <V> V retry(Callable<V> callable, Predicate<V> predicate) {
        return runWithRetry(DEFAULT_MAX_RETRY_COUNT, DEFAULT_RETRY_WAIT_TIME_MILLIS, callable, predicate);
    }

    public static <V> V retry(int maxRetryCount, long retryWaitTimeMillis, Callable<V> callable, Predicate<V> predicate) {
        return runWithRetry(maxRetryCount, retryWaitTimeMillis, callable, predicate);
    }

    private static <V> V runWithRetry(int maxRetryCount, long retryWaitTimeMillis,
            Callable<V> callable, Predicate<V> predicate) {
        int retryCount = 0;
        while (retryCount++ < maxRetryCount) {
            try {
                V result = callable.call();
                if (predicate.test(result)) {
                    return result;
                }
            } catch (Exception e) {
                LOG.error("There occur exception.", e);
            }
            if (retryWaitTimeMillis > 0) {
                sleepUninterruptibly(retryWaitTimeMillis, TimeUnit.MILLISECONDS);
            }
        }
        return null;
    }
}
