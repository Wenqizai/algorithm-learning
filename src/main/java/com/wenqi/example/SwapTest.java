package com.wenqi.example;

import java.util.Arrays;

/**
 * 交换a, b 数字位置
 *
 * @author liangwenqi
 * @date 2022/12/27
 */
public class SwapTest {
    public static void main(String[] args) {
        //int a = 1;
        //int b = 2;
        //System.out.println("a:" + a + ", b:" + b);
        //swap01(1, 2);
        //swap02(1, 2);

        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        reverseArray(arr);
    }

    /**
     * 交换数组位置
     */
    public static void reverseArray(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            int a = arr[first];
            int b = arr[last];
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            arr[first] = a;
            arr[last] = b;
            first++;
            last--;
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void swap01(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("swap01 -> a:" + a + ", b:" + b);
    }

    public static void swap02(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("swap02 -> a:" + a + ", b:" + b);
    }
}
