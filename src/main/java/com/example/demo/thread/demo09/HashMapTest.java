package com.example.demo.thread.demo09;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, Integer> map = new HashMap<String, Integer>(2);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), atomicInteger.getAndIncrement());
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println(map.size());
//        for (Map.Entry<String, Integer> key : map.entrySet()){
//            System.out.println(key.getKey() + "," + key.getValue());
//        }
    }
}
