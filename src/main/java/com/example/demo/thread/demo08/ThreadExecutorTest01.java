package com.example.demo.thread.demo08;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExecutorTest01 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        ExecutorService executor = Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1,
//                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 40; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("任务执行结束:" + count.getAndIncrement());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

//            Thread.sleep(100);
        }
        executor.shutdown();

    }
}
