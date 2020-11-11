package com.example.demo.thread.demo03;

import lombok.SneakyThrows;

class MyService03{
    synchronized public void say() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            if(i == 3){
                Thread.sleep(3000);
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
    public void hello() throws InterruptedException {
        synchronized ("a"){
            for (int i = 0; i < 10; i++){
                if(i == 3){
                    Thread.sleep(3000);
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

class MyThread10 extends Thread{
    private MyService03 myService03;
    public MyThread10(MyService03 myService03){
        this.myService03 = myService03;
    }

    @SneakyThrows
    @Override
    public void run(){
        synchronized (myService03){
            myService03.hello();
        }
    }
}

class MyThread11 extends Thread{
    private MyService03 myService03;
    public MyThread11(MyService03 myService03){
        this.myService03 = myService03;
    }

    @SneakyThrows
    @Override
    public void run(){
        myService03.say();
    }
}

public class ThreadSynchronizedThisAndObject {
    public static void main(String[] args) throws InterruptedException {
        MyService03 myService03 = new MyService03();
        MyThread10 myThread10 = new MyThread10(myService03);
        myThread10.setName("A");
        MyThread11 myThread11 = new MyThread11(myService03);
        myThread11.setName("B");
        myThread10.start();
        Thread.sleep(100);
        myThread11.start();
    }
}
