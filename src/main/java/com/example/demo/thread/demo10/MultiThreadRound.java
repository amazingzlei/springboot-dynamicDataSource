package com.example.demo.thread.demo10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadRound {

    public static void main(String[] args) {

        final AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                ad.loopA();
            }
        }, "A").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                ad.loopB();
            }
        }, "B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                ad.loopC();
            }
        }, "C").start();

    }

}

class AlternateDemo {
    // 线程辨识
    private volatile int num = 1;
    // 总数
    private AtomicInteger count = new AtomicInteger(1);
    // lock
    private Lock lock = new ReentrantLock();
    // condition
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            while(count.get() <= 100){
                // 判断是否轮到当前线程打印数据
                if(num != 1){
                    // 线程等待
                    condition1.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    num = 2;
                }
                condition2.signal();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void loopB(){
        lock.lock();
        try {
            while(count.get() <= 100){
                // 判断是否轮到当前线程打印数据
                if(num != 2){
                    // 线程等待
                    condition2.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    // 唤起其他线程
                    num = 3;
                }
                condition3.signal();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void loopC(){
        lock.lock();
        try {
            while(count.get() <= 100){
                // 判断是否轮到当前线程打印数据
                if(num != 3){
                    // 线程等待
                    condition3.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    // 唤起其他线程
                    num = 1;
                }
                condition1.signal();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
