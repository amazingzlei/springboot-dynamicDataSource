package com.example.demo.thread.demo10;

// 快速排序，先找一个基准值，然后从后往前找第一个比他小的，从前往后找第一个比他大的，然后在递归
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        quickSort2(array, 0, array.length - 1);
        for (int arr : array
        ) {
            System.out.print(arr + " ");
        }
    }

    public static void quickSort2(int[] arr, int low, int high) {
        int leftIndex = low;
        int rightIndex = high;
        int key = arr[leftIndex];
        while (rightIndex > leftIndex) {

            while (rightIndex > leftIndex && key <= arr[rightIndex]) {
                rightIndex--;
            }
            if (key > arr[rightIndex]) {
                int tmp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = tmp;
            }

            while (rightIndex > leftIndex && key >= arr[leftIndex]) {
                leftIndex++;
            }
            if (key < arr[leftIndex]) {
                int tmp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = tmp;
            }
        }
        if (leftIndex > low) {
            quickSort2(arr, low, leftIndex - 1);
        }
        if (rightIndex < high) {
            quickSort2(arr, rightIndex + 1, high);
        }
    }


    public static void quickSort(int[] arr, int low, int high) {
        // 左侧索引
        int leftIndex = low;
        int rightIndex = high;
        // 基准值
        int key = arr[leftIndex];
        while (rightIndex > leftIndex) {
            while (rightIndex > leftIndex && arr[rightIndex] >= key) {
                rightIndex--;
            }
            if (arr[rightIndex] < key) {
                int tmp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = tmp;
            }
            while (rightIndex > leftIndex && arr[leftIndex] <= key) {
                leftIndex++;
            }
            if (arr[leftIndex] > key) {
                int tmp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tmp;
            }
        }
        if (leftIndex > low) {
            quickSort2(arr, low, leftIndex - 1);
        }
        if (rightIndex < high) {
            quickSort2(arr, rightIndex + 1, high);
        }
    }
}
