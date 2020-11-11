package com.example.demo.thread.demo03;

class MyThread05 extends Thread{
    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // 让出CPU资源
            Thread.yield();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

public class ThreadYield {

    public static void main(String[] args) {
        MyThread05 myThread05 = new MyThread05();
        myThread05.start();
    }

}
