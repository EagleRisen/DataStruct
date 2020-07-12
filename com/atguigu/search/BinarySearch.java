package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        //找到同一个值的所有位置
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List resIndexList = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList =" + resIndexList);
    }

    public static List binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                } else {
                    resIndexList.add(temp);
                    temp--;
                }
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                } else {
                    resIndexList.add(temp);
                    temp++;
                }
            }

            return resIndexList;
        }
    }
}
