package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * 基数排序, 给定数组和最高位数, digit 位数
 * 计数排序步骤:
 * 1. 提取指定位数的数字, 组成一个新数组
 * 2. 新数组使用计数排序, 指定位数的最大值是 9, 对应数组长度是 10
 *
 * @author liangwenqi
 * @date 2024/8/1
 */
public class P08RadixSort {
    public static void main(String[] args) {
        //testCounterSort();
        testRadixSort();
    }

    private static void testRadixSort() {
        //int[] origin = {2, 5, 3, 0, 2, 3, 0, 3};
        //System.out.println(Arrays.toString(radixSort(origin, 1)));

        int[] origin = {112, 25, 213, 0, 2, 313, 0, 3};
        // expect: [0, 0, 2, 3, 25, 112, 213, 313]
        radixSort(origin, 3);
    }

    private static void testCounterSort() {
        int[] origin = {2, 5, 3, 0, 2, 3, 0, 3};
        // expect: [0, 0, 2, 2, 3, 3, 3, 5]
        System.out.println(Arrays.toString(counterSort(origin, 1)));
    }


    private static void radixSort(int[] nums, int maxDigit) {
        for (int i = 1; i <= maxDigit; i++) {
            nums = counterSort(nums, i);
        }
    }

    /**
     * 计数排序
     */
    private static int[] counterSort(int[] nums, int digit) {
        int[] counter = new int[10];
        int[] result = new int[nums.length];

        // 统计 nums 值的数量
        for (int num : nums) {
            int index = P08ExtractNumDigit.extractNumDigit(num, digit);
            // 这里应该取得是位数, 而不是一整个数
            counter[index] += 1;
        }

        // 计算 counter 的累计值
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        // 从后往前遍历才能保证数组稳定性
        for (int j = nums.length - 1; j >= 0; j--) {
            int num = nums[j];
            int index = P08ExtractNumDigit.extractNumDigit(num, digit);

            result[counter[index] - 1] = num;
            counter[index] = counter[index] - 1;
        }

        System.out.println(Arrays.toString(result));

        return result;
    }


}
