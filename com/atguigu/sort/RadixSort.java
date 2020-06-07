package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        int max =  arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //得到最大的数的位数
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
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

                //清空第i + 1轮中的历史记录
                bucketElementCounts[k] = 0;
            }

            System.out.println("第" + (i + 1) +"轮，对个位的排序处理arr=" + Arrays.toString(arr));
        }
    }
}
