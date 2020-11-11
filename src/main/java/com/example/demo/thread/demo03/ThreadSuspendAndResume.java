package com.example.demo.thread.demo03;

class MyThread04 extends Thread{
    private Long count = 0L;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public void run() {
        while(true){
            count++;
        }
    }
}

public class ThreadSuspendAndResume {
    public static void main(String[] args) throws InterruptedException {
        MyThread04 myThread04 = new MyThread04();
        myThread04.start();
        Thread.sleep(5000);
        // 暂停
        myThread04.suspend();
        System.out.println("end");
//        System.out.println(myThread04.getCount());
//
//        // 五秒后查看效果
//        Thread.sleep(5000);
//        System.out.println(myThread04.getCount());
//
//        // 唤起线程
//        myThread04.resume();
//        System.out.println(myThread04.getCount());
//        Thread.sleep(5000);
//        System.out.println(myThread04.getCount());
//
//        myThread04.stop();
    }
}
