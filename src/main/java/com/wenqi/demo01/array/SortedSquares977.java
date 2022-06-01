package com.wenqi.demo01.array;

/**
 * @author Wenqi Liang
 * @date 2022/5/28
 */
public class SortedSquares977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        sortedSquares(nums);
    }
    public static int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        if (right == 0) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int[] result = new int[nums.length];
        int index = result.length - 1;
        int left = 0;
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
