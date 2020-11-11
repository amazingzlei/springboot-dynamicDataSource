package com.example.demo.thread.demo01;

class LoginServlet{
    private static String usernamea;
    private static String passworda;

    public static void doPost(String username, String password, String type) throws InterruptedException {
        System.out.println(type);
        usernamea = username;
        if(username == "a"){
            Thread.sleep(5000);
        }
        passworda = password;
        System.out.println("username=" + usernamea + ",password=" + passworda);
    }

}

class MyThread01 extends Thread{
    @Override
    public void run() {
        try {
            LoginServlet.doPost("a", "aa", "a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread02 extends Thread{
    @Override
    public void run() {
        try {
            LoginServlet.doPost("b", "bb", "b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Demo01 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();
        myThread01.start();
        myThread02.start();
    }
}
