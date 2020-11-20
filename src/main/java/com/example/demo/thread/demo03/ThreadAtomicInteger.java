package com.example.demo.thread.demo03;


import java.util.concurrent.atomic.AtomicInteger;

class MyThread14 extends Thread{
    private  static AtomicInteger count = new AtomicInteger(0);
    private  static void addCount(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName() + ":" + count.get());
    }

    @Override
    public void run(){
        addCount();
    }
}
/**
 * 原子性的类
 */
public class ThreadAtomicInteger {
    public static void main(String[] args) {
        MyThread14[] myThread14s = new MyThread14[100];
        for (int i = 0; i < 100; i++) {
            myThread14s[i] = new MyThread14();
        }

        for (int i = 0; i < 100; i++) {
            myThread14s[i].start();
        }
    }
}
