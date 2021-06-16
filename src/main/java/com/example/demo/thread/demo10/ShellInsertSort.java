package com.example.demo.thread.demo10;

// 希尔排序
public class ShellInsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        shellInsertSort2(array);
        for (int arr : array
        ) {
            System.out.print(arr + " ");
        }
    }

    public static void shellInsertSort2(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step = step / 2) {
            for (int i = step; i < arr.length; i++) {
                // 要插入的值
                int key = arr[i];
                // 有序队列的索引
                int j = i - step;
                while (j >= 0 && key < arr[j]) {
                    arr[j + step] = arr[j];
                    j = j - step;
                }
                if (j != i) {
                    arr[j + step] = key;
                }
            }
        }
    }

    public static void shellInsertSort(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step = step / 2) {
            for (int i = step; i < arr.length; i++) {
                int key = arr[i];
                int j = i - step;
                while (j >= 0 && key < arr[j]) {
                    arr[j + step] = arr[j];
                    j = j - step;
                }
                if (j != i) {
                    arr[j + step] = key;
                }
            }
        }
    }
}
