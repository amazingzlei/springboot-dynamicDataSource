package com.example.demo.thread.demo11;

import java.util.stream.LongStream;

public class Test01 {
    public static Object OBJECT = new Object();
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            synchronized (OBJECT) {
//                System.out.println("1");
//            }
//        }, "t1");
//
//        Thread t2 = new Thread(() -> {
//            synchronized (OBJECT) {
//                System.out.println("2");
//            }
//        }, "t2");
//        t2.start();
//        t2.join();
//        t1.start();
        Long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + ",耗时:" + (end - start));
    }
}
