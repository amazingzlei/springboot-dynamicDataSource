package com.example.demo.thread.demo05;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class MyThread01 extends Thread{
    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;
    public MyThread01(PipedOutputStream outputStream, WriteData writeData){
        this.writeData = writeData;
        this.pipedOutputStream = outputStream;
    }

    @SneakyThrows
    @Override
    public void run(){
        writeData.writeMethod(pipedOutputStream);
    }
}

class MyThread02 extends Thread{
    private ReadData readData;
    private PipedInputStream pipedInputStream;
    public MyThread02(PipedInputStream inputStream, ReadData readData){
        this.pipedInputStream = inputStream;
        this.readData = readData;
    }

    @SneakyThrows
    @Override
    public void run(){
        readData.readMethod(pipedInputStream);
    }
}

public class Run {
    public static void main(String[] args) throws IOException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();
        pipedInputStream.connect(pipedOutputStream);

        MyThread01 myThread01 = new MyThread01(pipedOutputStream, writeData);
        MyThread02 myThread02 = new MyThread02(pipedInputStream, readData);

        myThread01.run();
        myThread02.run();
    }
}
