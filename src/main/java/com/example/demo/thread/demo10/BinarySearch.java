package com.example.demo.thread.demo10;

// 二分查找
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{21, 25, 26, 35, 46, 51, 62, 78, 84, 95};
        System.out.println(query2(array, 78));
    }

    public static int query2(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid + 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int query(int[] array, int key) {
        // 起始位置
        int start = 0;
        // 结束位置
        int end = array.length - 1;
        while (start <= end) {
            // 中间位置
            int mid = (start + end) / 2;
            if (array[mid] < key) {
                start = mid + 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            } else if (array[mid] == key) {
                return mid + 1;
            }
        }
        return -1;
    }
}
