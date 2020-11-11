package com.example.demo.thread.demo03;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

class MyOneList{
    private List<String> list = new ArrayList<>();
    synchronized public void add(String data){
        list.add(data);
    }

    synchronized public int getSize(){
        return list.size();
    }
}

class MyService{
    public void addData(MyOneList oneList, String data) throws InterruptedException {
        synchronized(oneList){
            if(oneList.getSize() < 1){
                Thread.sleep(2000);
                oneList.add(data);
            }
        }

    }
}

class MyThread06 extends Thread{
    private MyOneList myOneList;
    public MyThread06(MyOneList oneList){
        this.myOneList = oneList;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        MyService myService = new MyService();
        myService.addData(myOneList, "A");
    }
}

class MyThread07 extends Thread{
    private MyOneList myOneList;
    public MyThread07(MyOneList oneList){
        this.myOneList = oneList;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        MyService myService = new MyService();
        myService.addData(myOneList, "B");
    }
}

public class ThreadSynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        MyOneList oneList = new MyOneList();
        MyThread06 myThread06 = new MyThread06(oneList);
        MyThread07 myThread07 = new MyThread07(oneList);
        myThread06.start();
        myThread07.start();
        Thread.sleep(6000);
        System.out.println(oneList.getSize());

    }
}
