package com.example.demo.thread.demo03;

import lombok.SneakyThrows;

class MyThread12 implements Runnable{

    private volatile boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(flag){
            System.out.println("A");
            Thread.sleep(1000);
        }
        System.out.println("程序终止");
    }
}

public class ThreadWithOutVolatile {
    public static void main(String[] args) throws InterruptedException {
        MyThread12 myThread12 = new MyThread12();
        new Thread(myThread12).start();
        myThread12.setFlag(false);
    }
}
