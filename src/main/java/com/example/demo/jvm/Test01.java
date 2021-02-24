package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms1024m(初始化堆大小) -Xmx1024m（堆最大大小） -XX:+PrintGCDetails（打印GC日志）
 */
public class Test01 {
    byte[] bytes = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println((double)maxMemory/1024/1024);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println((double)totalMemory/1024/1024);

        List<Test01> list = new ArrayList<>();
        while(true){
            list.add(new Test01());
        }
    }
}
