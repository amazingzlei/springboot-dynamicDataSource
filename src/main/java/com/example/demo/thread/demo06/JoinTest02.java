package com.example.demo.thread.demo06;


class MyThreadA extends Thread{

    private MyThreadB myThreadB;
    public MyThreadA(MyThreadB myThreadB){
        this.myThreadB = myThreadB;
    }

    @Override
    public void run() {
        try {
            synchronized (myThreadB){
                System.out.println("start A:" + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("end A:" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadB extends Thread{
    @Override
    synchronized public void run() {
        try {
            System.out.println("start B:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end B:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class JoinTest02 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadB myThreadB = new MyThreadB();
        MyThreadA myThreadA = new MyThreadA(myThreadB);
        myThreadA.start();
        myThreadB.start();
        myThreadB.join();
        System.out.println("main end");
    }
}
