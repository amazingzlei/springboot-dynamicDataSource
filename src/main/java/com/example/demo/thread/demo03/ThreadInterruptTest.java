package com.example.demo.thread.demo03;


/**
 * 1.interrupt 给线程设置中断标志
 * 2.interrupted 检测当前线程是否中断并且会清除中断状态
 *      注意:1）所谓的当前线程指的并不是哪个线程调用了interrupted方法，而是指interrupted方法在那个方法中运行，如
 *              下面的thread.interrupted()方法判断的是main线程是否中断，而不是thread线程中断
 *          2）清除中断状态指的是第一次调用是返回true表示已经中断，但是第二次调用时返回的是false
 * 3.isInterrupted 检测线程是否中断（非当前线程），他不会清除中断状态
 */
class MyThread02 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 1000000; i++) {
                if(this.interrupted()){
                    System.out.println("线程终止!!!");
                    throw new RuntimeException();
                }
                System.out.println(i);
            }
            System.out.println("end~~~~~~~~~~~~~~");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class ThreadInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread02 thread = new MyThread02();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        System.out.println(thread.interrupted());
//        System.out.println(thread.interrupted());
//        System.out.println(thread.isInterrupted());
//        System.out.println(thread.isInterrupted());
    }
}