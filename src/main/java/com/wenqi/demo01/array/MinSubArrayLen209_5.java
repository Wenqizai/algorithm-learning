package com.wenqi.demo01.array;

/**
 * @author Wenqi Liang
 * @date 2022/7/3
 */
public class MinSubArrayLen209_5 {
    public static void main(String[] args) {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口解法
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (end <= nums.length - 1) {
            if (nums[end] >= target) {
                return 1;
            }
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
