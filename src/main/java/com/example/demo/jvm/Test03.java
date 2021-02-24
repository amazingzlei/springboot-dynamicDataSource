package com.example.demo.jvm;

/**
 * 测试大对象放入老年代的大小
 * -Xms20m -Xmx20m -Xmn10m（新生区大小） -XX:+PrintGCDetails -XX:SurvivorRatio=8（伊甸园和幸存区比例）
 * -XX:PretenureSizeThreshold=3145728（大对象放入老年代）
 */
public class Test03 {
    public static void main(String[] args) {
        byte[] bytes ;
        bytes = new byte[5 * 1024 * 1024];
    }
}
