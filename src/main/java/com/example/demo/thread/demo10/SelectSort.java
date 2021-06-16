package com.example.demo.thread.demo10;

/**
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然
 * 后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * 选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面，或者将最大值放在最后面。
 * 但是过程不同，冒泡排序是通过相邻的比较和交换。而选择排序是通过对整体的选择，每一趟从前往后查找出无序区最小值，
 * 将最小值交换至无序区最前面的位置
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{98, 83, 21, 45, 78, 43, 12, 59, 63};
        sort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int tem = arr[min];
                arr[min] = arr[i];
                arr[i] = tem;
            }
        }
    }
}
