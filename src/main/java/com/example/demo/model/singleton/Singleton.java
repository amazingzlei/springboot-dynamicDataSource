package com.example.demo.model.singleton;

/**
 * 单例模式
 * 懒汉模式：调用方法是创建对象，可以是线程安全的，但是效率低
 * 饿汉模式: 一开始就创建好了对象，但是存在线程安全问题
 */
public class Singleton {
    public static void main(String[] args) {
        SingletonDemo singletonDemo1 = SingletonDemo.getIntance();
        SingletonDemo singletonDemo2 = SingletonDemo.getIntance();
        System.out.println(singletonDemo1 == singletonDemo2);
    }
}

class SingletonDemo{
    // 将自己作为属性
    private static volatile SingletonDemo singletonDemo = null;
    // 私有构造器
    private SingletonDemo(){
    }
    // 提供对外暴露实例的方法
    public static synchronized SingletonDemo getIntance(){
        if(singletonDemo != null){
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }
}
