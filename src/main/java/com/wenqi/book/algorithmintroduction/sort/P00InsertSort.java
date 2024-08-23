package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * @author liangwenqi
 * @date 2024/8/7
 */
public class P00InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 3, 4, 6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1]  = arr[j] ;
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
