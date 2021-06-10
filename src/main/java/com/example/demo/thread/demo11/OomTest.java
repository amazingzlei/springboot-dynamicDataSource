package com.example.demo.thread.demo11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OomTest {
    public static void main(String[] args) {
        new Thread(() -> {
            List<byte[]> list=new ArrayList<byte[]>();
            while(true){
                System.out.println(new Date().toString()+Thread.currentThread()+"==");
                byte[] b = new byte[1024*1024*10];
                list.add(b);
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while(true){
                System.out.println(new Date().toString()+Thread.currentThread()+"==");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
