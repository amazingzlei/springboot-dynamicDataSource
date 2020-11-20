package com.example.demo.thread.demo03;

class MyThread13 extends Thread{
    private  static int count = 0;
    private synchronized static void addCount(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }

    @Override
    public void run(){
        addCount();
    }
}

/**
 * 验证volatile没有原子性
 */
public class ThreadVolatileWithoutAtomic {
    public static void main(String[] args) {
        MyThread13[] myThread13s = new MyThread13[100];
        for (int i = 0; i < 100; i++) {
            myThread13s[i] = new MyThread13();
        }

        for (int i = 0; i < 100; i++) {
            myThread13s[i].start();
        }
    }
}
