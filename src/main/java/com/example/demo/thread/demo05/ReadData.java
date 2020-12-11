package com.example.demo.thread.demo05;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream inputStream) throws IOException {
        System.out.println("read:");
        byte[] byteArray = new byte[20];
        int readLength = inputStream.read(byteArray);
        while(readLength != -1){
            String newData = new String(byteArray, 0, readLength);
            System.out.println(newData);
            readLength = inputStream.read(byteArray);
        }
        System.out.println();
        inputStream.close();
    }
}
