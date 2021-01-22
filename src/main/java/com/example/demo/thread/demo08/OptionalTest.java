package com.example.demo.thread.demo08;

import java.util.Optional;
import java.util.function.BiPredicate;

public class OptionalTest {
    public static void main(String[] args) {
        User user = null;
        User user1 = new User();
        user1.setAge(20);
//        Optional.ofNullable(null).ifPresent((x)->System.out.println("unknown"));
        System.out.println(Optional.ofNullable(user).isPresent());
    }
}
