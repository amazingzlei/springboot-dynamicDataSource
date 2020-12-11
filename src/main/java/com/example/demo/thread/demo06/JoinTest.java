package com.example.demo.thread.demo06;

class MyThread extends Thread{
    @Override
    public void run() {
        int seconds = (int)(Math.random() * 10000);
        try {
            Thread.sleep(seconds);
            System.out.println(seconds);
            System.out.println("子线程执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        System.out.println("等待子线程结束");
    }
}
