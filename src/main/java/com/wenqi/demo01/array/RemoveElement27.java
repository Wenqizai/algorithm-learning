package com.wenqi.demo01.array;

/**
 * @author Wenqi Liang
 * @date 2022/5/28
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {3};
        int val = 3;
        removeElement(nums, val);
    }
    public static int removeElement(int[] nums, int val) {
        int p = nums.length - 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > p) {
                return count;
            }
            if (nums[i] == val) {
                while (nums[p] == val) {
                    p--;
                    if (i > p) {
                        return count;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
            }
            count++;
        }
        return count;
    }
}
