package com.example.demo.model.factory;

/**
 * 工厂模式：
 * 抽象工厂: 提供了创建产品的接口
 * 具体工厂: 主要是实现抽象工厂中的抽象方法，完成具体产品的创建
 * 抽象产品: 定义了产品的规范，描述了产品的主要特性和功能
 * 具体产品: 实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应
 */
public class Factory {
    public static void main(String[] args) {
        // 创建抽象工厂
        AbtractFactory abtractFactory = new AppleFactory();
        abtractFactory.newProduct().creatProduct();
    }
}

/**
 * 抽象工厂
 */
interface AbtractFactory{
    AbstractProduct newProduct();
}

class AppleFactory implements AbtractFactory{

    @Override
    public AbstractProduct newProduct() {
        return new AppleProduct();
    }
}

class OrangeFactory implements AbtractFactory{

    @Override
    public AbstractProduct newProduct() {
        return new OrangeProduct();
    }
}

/**
 * 抽象产品，定义产品规范
 */
interface AbstractProduct{
    void creatProduct();
}

/**
 * 具体产品
 */
class AppleProduct implements AbstractProduct{

    @Override
    public void creatProduct() {
        System.out.println("创建了一个苹果");
    }
}

/**
 * 具体产品
 */
class OrangeProduct implements AbstractProduct{

    @Override
    public void creatProduct() {
        System.out.println("创建了一个橘子");
    }
}