package com.example.demo.thread.demo06;

import java.sql.Date;

/**
 * ThreadLocal是针对每个线程而言的，父线程和子线程的值是不一样的
 * InheritableThreadLocal可以让子线程继承父线程的值，如果想要更改值，可以通过重写
 * childValue方法更改
 */
class ThreadLocalExt extends InheritableThreadLocal{
    @Override
    protected Object initialValue() {
        return new Date(System.currentTimeMillis()).getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return new Date(System.currentTimeMillis()).getTime();
    }
}

class ThreadLocalToo1s{
    public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();
}

public class ThreadLocalTest {
    private static ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    private static ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
//        longLocal.set(1L);
//        System.out.println(longLocal.get());
        System.out.println("main线程:" + ThreadLocalToo1s.threadLocalExt.get());

        new Thread(){
            public void run(){
                System.out.println("子线程" + ThreadLocalToo1s.threadLocalExt.get());
            }
        }.start();
    }
}
