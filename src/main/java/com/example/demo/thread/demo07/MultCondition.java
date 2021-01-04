package com.example.demo.thread.demo07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyServiceB{
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("A await时间为" + System.currentTimeMillis());
            conditionA.await();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("B await时间为" + System.currentTimeMillis());
            conditionB.await();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void signal_A(){
        try {
            lock.lock();
            System.out.println("A signal时间为" + System.currentTimeMillis());
            conditionA.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void signal_B(){
        try {
            lock.lock();
            System.out.println("B signal时间为" + System.currentTimeMillis());
            conditionB.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

class MyThreadAA extends Thread{
    private MyServiceB myServiceB;
    public MyThreadAA(MyServiceB myServiceB){
        this.myServiceB = myServiceB;
    }

    @Override
    public void run() {
        myServiceB.awaitA();
    }
}

class MyThreadBB extends Thread{
    private MyServiceB myServiceB;
    public MyThreadBB(MyServiceB myServiceB){
        this.myServiceB = myServiceB;
    }

    @Override
    public void run() {
        myServiceB.awaitB();
    }
}

public class MultCondition {
    public static void main(String[] args) throws InterruptedException {
        MyServiceB myServiceB = new MyServiceB();
        MyThreadAA myThreadAA = new MyThreadAA(myServiceB);
        MyThreadBB myThreadBB = new MyThreadBB(myServiceB);
        myThreadAA.start();
        myThreadBB.start();
        Thread.sleep(3000);
        myServiceB.signal_A();
    }
}
