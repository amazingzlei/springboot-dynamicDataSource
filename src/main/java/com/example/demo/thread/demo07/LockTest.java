package com.example.demo.thread.demo07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService{
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName:" + Thread.currentThread().getName() + ",i=" + i);
        }
        lock.unlock();
    }
}

class ThreadA extends Thread{
    private MyService myService;
    public ThreadA(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}

public class LockTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a1 = new ThreadA(myService);
        ThreadA a2 = new ThreadA(myService);
        ThreadA a3 = new ThreadA(myService);
        ThreadA a4 = new ThreadA(myService);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
