package com.lwm.chapter2.fake_async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weeming
 * @date 2021/10/23 17:15
 */
public class TimeServerHandlerPool {

    private ThreadPoolExecutor executor;

    public TimeServerHandlerPool(int poolSize, int queueSize) {
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                poolSize,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}
