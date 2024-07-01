package com.wenqi.book.algorithmintroduction;

import java.util.Arrays;

/**
 * @author Wenqi Liang
 * @date 2024/6/19
 */
public class P01MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 6, 8, 2, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /* 归并排序 */
    static void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) return; // 当子数组长度为 1 时终止递归
        // 划分阶段
        int mid = left + (right - left) / 2; // 计算中点
        mergeSort(nums, left, mid); // 递归左子数组
        mergeSort(nums, mid + 1, right); // 递归右子数组
        // 合并阶段

        System.out.println("merge left: " + left + ", mid: " + mid + ", right: " + right);
        merge(nums, left, mid, right);
    }

    /**
     * 合并两个有序数组
     * 数组1 : left ~ mid
     * 数组2 : mid+1 ~ right
     * <p>
     * 合并两个有序数组, 合并后的结果放在 nums[left ~ right] 中,
     * 需要满足合并完的数组大小等于两个数组的大小之和, 此时需要借助临时数组 tmp 存储合并后的结果, 空间复杂度 O(n)
     */
    static void merge(int[] nums, int left, int mid, int right) {
        // 创建一个临时数组 tmp ，用于存放合并后的结果
        int[] tmp = new int[right - left + 1];

        // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
        // 左数组开始索引 left
        // 右数组开始索引 mid+1
        // 临时数组开始索引 0
        int i = left, j = mid + 1, k = 0;

        // 保证数组不越界情况下, 遍历两个数组, 比较指针指向的元素大小, 小的放入临时数组中
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                tmp[k] = nums[j];
                j++;
            }
            k++;
        }

        // 如果左子数组还有剩余元素，证明 left.size > right.size
        // 则将剩余元素复制到临时数组中
        while (i <= mid) {
            tmp[k] = nums[i];
            k++;
            i++;
        }

        // 如果右子数组还有剩余元素，证明 left.size < right.size
        // 则将剩余元素复制到临时数组中
        while (j <= right) {
            tmp[k] = nums[j];
            k++;
            j++;
        }

        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }


}
