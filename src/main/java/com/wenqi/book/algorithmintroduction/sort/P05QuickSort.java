package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快速排序:
 * 1. 找一个数组中间数, right的数比他大, left的数比小
 * 2. 不断拆分数组直至数组right的数比left的数大
 *
 * @author liangwenqi
 * @date 2024/7/23
 */
public class P05QuickSort {

    public static void main(String[] args) {
        //testQuickSort();
        testPartition();
    }

    private static void testQuickSort() {
        // test1: 正常数组
        int[] nums = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));


        // test2: 中间数在 right 位置的数组
        int[] nums2 = {4, 1, 3, 2, 5};
        quickSort(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums2));

        // test2: 中间数在 left 位置的数组
        int[] nums3 = {4, 3, 2, 5, 1};
        quickSort(nums3, 0, nums3.length - 1);
        System.out.println(Arrays.toString(nums3));


        // test4: 两个元素的数组
        int[] nums4 = {3, 4};
        quickSort(nums4, 0, nums4.length - 1);
        System.out.println(Arrays.toString(nums4));

        // test5: 元素相同的数组
        int[] nums5 = {3, 3, 3, 3, 3, 3};
        quickSort(nums5, 0, nums5.length - 1);
        System.out.println(Arrays.toString(nums5));


        // test6: 元素顺序一致的数组
        int[] nums6 = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        quickSort(nums6, 0, nums6.length - 1);
        System.out.println(Arrays.toString(nums6));
    }

    private static void testPartition() {
        // test1
        int[] nums = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        System.out.println("test1 => mid == 4: " + Objects.equals(calPartition(nums, 0, nums.length - 1), 4));

        // test2
        int[] nums2 = {4, 1, 3, 2, 5};
        System.out.println("test2 => mid == 4: " + Objects.equals(calPartition(nums2, 0, nums2.length - 1), 4));

        // test3
        int[] nums3 = {4, 3, 2, 5, 1};
        System.out.println("test3 => mid == 0: " + Objects.equals(calPartition(nums3, 0, nums3.length - 1), 0));

        // test4
        int[] nums4 = {3, 4};
        System.out.println("test4 => mid == 1: " + Objects.equals(calPartition(nums4, 0, nums4.length - 1), 1));

        // test5
        int[] nums5 = {3, 3, 3, 3, 3, 3};
        System.out.println("test5 => mid == 0: " + Objects.equals(calPartition(nums5, 0, nums5.length - 1), 0));

        // test6
        int[] nums6 = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        System.out.println("test6 => mid == 9: " + Objects.equals(calPartition(nums6, 0, nums6.length - 1), 9));
    }

    /**
     * 快排:
     * 1. 找到数组中间数下标 mid,  nums[left, mid - 1] < nums[mid], nums[mid] < nums[mid + 1, right]
     * 2. 拆分子数组 nums[left, mid - 1], nums[mid + 1, right], 递归查找他们之间的中间数下标 mid
     *
     * @param nums  指定数组
     * @param left  数组的左边下标
     * @param right 数组的右边下标
     */
    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = calPartition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    /**
     * 寻找中间数 mid
     * 1. 设定比中间数小的数组范围 left - 1 ~ i (注意当数组中没有比 mid 小的数时, i = left - 1)
     * 2. 设定比中间数大的数组范围 i + 1 ~ j (注意当数组中没有比 mid 大的数时, j = i + 1)
     */
    private static int calPartition(int[] nums, int left, int right) {
        // 随机取一个中间数
        int dummy = nums[right];
        // 比中间数小左下标边界
        int min = left - 1;
        // 比中间数大右下标边界
        int max = left;

        // 不断推进右下标边界
        while (max < right) {
            // 如果发现有一个数比中间数小, exchange(nums[min + 1], num[max])
            if (nums[max] < dummy) {
                min++;
                int temp = nums[min];
                nums[min] = nums[max];
                nums[max] = temp;
            }
            max++;
        }

        // 将中间数返回中间位置, exchange(nums[min + 1], num[right])
        nums[right] = nums[min + 1];
        nums[min + 1] = dummy;

        return min + 1;
    }
}
