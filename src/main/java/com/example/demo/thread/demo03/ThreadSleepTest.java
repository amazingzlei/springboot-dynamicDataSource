package com.example.demo.thread.demo03;

class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadSleepTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
    }
}
