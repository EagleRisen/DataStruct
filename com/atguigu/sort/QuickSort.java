package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int pivot = arr[left];
            while (l < r) {

                while (l < r && arr[r] >= pivot) {
                    r--;
                }

                if (l < r) {
                    arr[l++] = arr[r];
                }

                while (l < r && arr[l] <= pivot) {
                    l++;
                }

                if (l < r) {
                    arr[r--] = arr[l];
                }
            }

            arr[l] = pivot;
            quickSort(arr, left, l - 1);
            quickSort(arr, l+ 1, right);
        }

    }
}
