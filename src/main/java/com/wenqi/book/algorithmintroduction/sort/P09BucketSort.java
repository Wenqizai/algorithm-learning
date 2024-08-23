package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * 桶排序
 *
 * @author liangwenqi
 * @date 2024/8/7
 */
public class P09BucketSort {
    /**
     * 为什么要用 0xf, 因为这样可以很好使用位运算取余
     */
    private static final int bucketSize = 0xf;
    private static final int[][] bucketArr = new int[bucketSize][];

    public static void main(String[] args) {
        testBucketSort();
    }

    private static void testBucketSort() {
        // todo bucketSize 大小的确定
        int[] origin = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println(Arrays.toString(bucketSort(origin)));
    }

    public static int[] bucketSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        for (int num : nums) {
            // 计算桶的位置
            int index = num & bucketSize;

            int[] storeArr = bucketArr[index];

            // 如果桶中没有数据, 则将 num 添加进去
            if (storeArr == null) {
                storeArr = new int[1];
                storeArr[0] = num;
            } else {
                // 如果桶中有数据, 则对数据进行插入排序
                storeArr = Arrays.copyOf(storeArr, storeArr.length + 1);
                // 放到最后一个位置
                storeArr[storeArr.length - 1] = num;
                for (int i = storeArr.length - 2; i >= 0; i--) {
                    if (storeArr[i + 1] >= storeArr[i]) {
                        break;
                    }

                    // 交换两者位置
                    int temp = storeArr[i + 1];
                    storeArr[i + 1] = storeArr[i];
                    storeArr[i] = temp;
                }
            }

            bucketArr[index] = storeArr;
        }

        // 遍历桶取出相关数字
        int[] result = new int[nums.length];
        int index = 0;
        for (int[] arr : bucketArr) {
            if (arr == null) {
                continue;
            }
            for (int num : arr) {
                result[index] = num;
                index++;
            }
        }

        return result;
    }
}
