package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * 最大堆排序
 * 堆排序内容: 1. 堆化 maxHeapify, 2. 构建堆 buildMaxHeap,  3. 堆排序 heapSort
 * @author Wenqi Liang
 * @date 2024/7/21
 */
public class P03MaxHeapSort {
    public static void main(String[] args) {
//        testMaxHeapify();
//        testBuildMaxHeap();
        testHeapSort();
    }


    /**
     * result: [1, 2, 3, 4, 7, 8, 9, 10, 14, 16]
     */
    private static void testHeapSort() {
        int[] nums = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * result: [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
     */
    private static void testBuildMaxHeap() {
        int[] nums = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        buildMaxHeap(nums);
        System.out.println("result => " + Arrays.toString(nums));
    }

    /**
     * result: [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
     */
    private static void testMaxHeapify() {
        int[] nums = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        maxHeapify(nums, nums.length, 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        System.out.println("buildMaxHeap => " + Arrays.toString(nums));
        int n = nums.length - 1;
        while (n >= 0) {
            int max = nums[0];
            nums[0] = nums[n];
            nums[n] = max;
            maxHeapify(nums, n, 0);
            n--;
        }
    }

    /**
     * 给定数组构造最大堆结构, 从 n / 2 索引开始建造
     */
    public static void buildMaxHeap(int[] nums) {
        int index = nums.length / 2;
        while (index >= 0) {
            maxHeapify(nums, nums.length, index);
            index--;
        }
    }

    /**
     * 给定数组和索引, 以该索引作为父节点, 检查并实现最大堆化
     */
    public static void maxHeapify(int[] nums, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int large = i;

        if (left < length && nums[left] > nums[i]) {
            large = left;
        }

        if (right < length && nums[right] > nums[large]) {
            large = right;
        }

        if (large != i) {
            // 交换
            int temp = nums[i];
            nums[i] = nums[large];
            nums[large] = temp;

            // 再次检查是否需要最大堆化
            maxHeapify(nums, length, large);
        }
    }
}
