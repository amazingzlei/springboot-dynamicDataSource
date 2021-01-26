package com.example.demo.thread.demo08;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        user1.setName("zl");
        Supplier<String> supplier = user::getName;
        Supplier<String> supplier2 = user1::getName;
        System.out.println(supplier.get());
        String s = Optional.ofNullable(supplier.get()).orElseGet(supplier2);
        System.out.println(s);
    }
}
