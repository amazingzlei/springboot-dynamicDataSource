package com.example.demo.thread.demo02;

class CountOperate extends Thread{
    public CountOperate(){
        System.out.println("CountOperate--begin");
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("thread.currentThread.isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run(){
        System.out.println("CountOperate--begin");
        System.out.println("thread.currentThread.isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOperate--end");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        countOperate.start();
        Thread thread = new Thread(countOperate);
        thread.start();
//        System.out.println(thread.isAlive());
    }
}
