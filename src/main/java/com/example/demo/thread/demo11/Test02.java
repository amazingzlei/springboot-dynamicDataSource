package com.example.demo.thread.demo11;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@Log4j2
public class Test02 {
    public static void main(String[] args) {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                TemporalAccessor accessor = dfm.parse("2021-05-20");
                log.info("time:{}", accessor);
            }).start();
        }
    }

    private static void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    sdf.parse("2021-05-20");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
