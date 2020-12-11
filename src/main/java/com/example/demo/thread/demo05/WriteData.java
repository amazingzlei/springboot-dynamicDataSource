package com.example.demo.thread.demo05;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) throws IOException {
        System.out.println("write:");
        for (int i = 0; i < 100; i  ++) {
            String outData = "" + (i+1);
            outputStream.write(outData.getBytes());
            System.out.println(outData);
        }
        System.out.println();
        outputStream.close();
    }
}
