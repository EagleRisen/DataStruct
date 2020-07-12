package com.atguigu.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, -1, -100};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
//        System.out.println("堆排序");
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0 , arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        //从第一个非叶子节点进行堆化，知道最后已经构成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //之后调制只需要从根节点开始调整，一个一个交换到最后，
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            adjustHeap(arr, 0, j);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     * @param i 表示非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }
}
