package com.example.demo.thread.demo10;

// 冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
//        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        bubbleSort(array, array.length);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void bubbleSort(int[] arr, int len) {
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr, int len) {
        for (int i = 1; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
