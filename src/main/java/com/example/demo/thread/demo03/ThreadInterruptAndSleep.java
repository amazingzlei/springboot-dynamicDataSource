package com.example.demo.thread.demo03;

import lombok.SneakyThrows;

class MyThread03 extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        int i = 0;
        while(true){
            Thread.sleep(2000);
            System.out.println(i++);
        }
    }
}

public class ThreadInterruptAndSleep {
    public static void main(String[] args) throws InterruptedException {
        MyThread03 myThread03 = new MyThread03();
        myThread03.start();
        Thread.sleep(5000);
        myThread03.stop();
    }
}
