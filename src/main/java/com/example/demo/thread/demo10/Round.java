package com.example.demo.thread.demo10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Round {
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.methodA();
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.methodB();
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.methodC();
            }
        }, "C").start();
    }
}

class Demo {
    // 线程执行标志
    private volatile int num = 1;
    // 执行的总数
    private AtomicInteger count = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void methodA() {
        lock.lock();
        try {
            while (count.get() < 100) {
                if(num != 1){
                    condition1.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    // 切换线程标志
                    num = 2;
                }
                // 唤醒线程二
                condition2.signal();
            }
        } catch (Exception e) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            while (count.get() < 100) {
                if(num != 2){
                    condition2.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    // 切换线程标志
                    num = 3;
                }
                // 唤醒线程二
                condition3.signal();
            }
        } catch (Exception e) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

    public void methodC() {
        lock.lock();
        try {
            while (count.get() < 100) {
                if(num != 3){
                    condition3.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + ":" + count.getAndIncrement());
                    // 切换线程标志
                    num = 1;
                }
                // 唤醒线程二
                condition1.signal();
            }
        } catch (Exception e) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

}
