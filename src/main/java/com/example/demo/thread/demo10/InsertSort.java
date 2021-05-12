package com.example.demo.thread.demo10;

// 插入排序 默认第一个有序，从无序的队列开始依次遍历，然后有序队列从后往前依次遍历，找到比自己小的
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        sort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int key = arr[i];
            while (j > 0 && key < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = key;
            }
        }
    }

    public static int[] sort1(int[] arr) {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        return arr;
    }
}
