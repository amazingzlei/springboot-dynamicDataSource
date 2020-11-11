package com.example.demo.thread.demo03;

class DealThread implements Runnable{

    private String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run() {
        if(username.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("按照lock1 -> lock2顺序执行");
                }
            }
        }

        if(username.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("按照lock2 -> lock1顺序执行");
                }
            }
        }
    }
}

public class ThreadDeathLock {
    public static void main(String[] args) throws InterruptedException {
        DealThread dealThread = new DealThread();
        dealThread.setFlag("a");
        Thread thread1 = new Thread(dealThread);
        thread1.start();
        Thread.sleep(200);
        dealThread.setFlag("b");
        Thread thread2 = new Thread(dealThread);
        thread2.start();
    }
}
