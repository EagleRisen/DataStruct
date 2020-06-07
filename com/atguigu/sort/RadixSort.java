package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        int index = 0;
        for (int k = 0; k < bucketElementCounts.length; k++) {
            if (bucketElementCounts[k] != 0) {
                //循环该桶，第k个桶
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //放入arr数组
                    arr[index++] = bucket[k][l];
                }
            }
        }

        System.out.println("第1轮，对个位的排序处理arr=" + Arrays.toString(arr));
    }
}
