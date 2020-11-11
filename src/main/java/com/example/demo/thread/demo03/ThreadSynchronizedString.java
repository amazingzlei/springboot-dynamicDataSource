package com.example.demo.thread.demo03;

class MyService01{
    public void print(String data){
        synchronized (data){
            while(true){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}

class MyThread08 extends Thread{
    private MyService01 myService01;
    public MyThread08(MyService01 myService01){
        this.myService01 = myService01;
    }

    @Override
    public void run(){
        myService01.print("AA");
    }
}

class MyThread09 extends Thread{
    private MyService01 myService01;
    public MyThread09(MyService01 myService01){
        this.myService01 = myService01;
    }

    @Override
    public void run(){
        myService01.print("AA");
    }
}

public class ThreadSynchronizedString {
    public static void main(String[] args) {
        MyService01 myService01 = new MyService01();
        MyThread08 myThread08 = new MyThread08(myService01);
        MyThread09 myThread09 = new MyThread09(myService01);
        myThread08.setName("A");
        myThread09.setName("B");
        myThread08.start();
        myThread09.start();
    }
}
