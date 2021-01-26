package com.example.demo.thread.demo08;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    public void say(){
        System.out.println(this.name);
    }
}
