package com.example.demo.thread.demo07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println(new Date().getTime());
    }
}

public class TimeTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer(true);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2021-01-05 14:51:30");
        timer.schedule(new MyTask(), parse);
    }
}
