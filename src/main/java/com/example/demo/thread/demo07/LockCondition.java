package com.example.demo.thread.demo07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyServiceA{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为" + System.currentTimeMillis());
            condition.await();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

class MyThread extends Thread{
    private MyServiceA myService;
    public MyThread(MyServiceA myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}

public class LockCondition {
    public static void main(String[] args) throws InterruptedException {
        MyServiceA myServiceA = new MyServiceA();
        MyThread myThread = new MyThread(myServiceA);
        myThread.start();
        Thread.sleep(3000);
        myServiceA.signal();
    }
}
