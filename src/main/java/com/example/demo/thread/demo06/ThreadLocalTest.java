package com.example.demo.thread.demo06;

public class ThreadLocalTest {
    private static ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    private static ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
        longLocal.set(1L);
        System.out.println(longLocal.get());

        new Thread(){
            public void run(){
                System.out.println(longLocal.get());
                longLocal.set(2L);
                System.out.println(longLocal.get());
            }
        }.start();
    }
}
