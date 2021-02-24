package com.example.demo.thread.demo08;

import lombok.SneakyThrows;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    @SneakyThrows
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        user1.setName("zl");
        Supplier<String> supplier = user::getName;
        Supplier<String> supplier2 = user1::getName;
        System.out.println(supplier.get());
        String s = Optional.ofNullable(supplier.get()).orElseGet(supplier2);
        System.out.println(s);

        // 直接赋值引用，user2和user3指向同一个地址
        User user2 = new User();
        user2.setName("a");
        User user3 = user2;
        user3.setAge(20);
        System.out.println(user2);

        User user4 = (User)user2.clone();
        user4.setAge(25);
        System.out.println(user2);

    }
}
