package com.wenqi.demo01.array;

/**
 * 二分法查找
 * <p>
 * https://leetcode.cn/problems/binary-search/
 *
 * @author Wenqi Liang
 * @date 2022/5/24
 */
public class Search704 {
    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        if (high < 0 || target < nums[0] || target > nums[high]) {
            return -1;
        }
        int low = 0;
        while (high >= low) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > target) {
                high = --mid;
            } else if (nums[mid] < target) {
                low = ++mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
