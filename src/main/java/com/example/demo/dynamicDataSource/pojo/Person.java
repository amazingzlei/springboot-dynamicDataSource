package com.example.demo.dynamicDataSource.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Person {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Timestamp timestamp;
}
