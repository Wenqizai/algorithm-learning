package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * 计数排序要求: 输入 int[] origin, 元素必须符合 0 ~ maxNum 的正整数。
 * 1. 新建数组 counter 用来保存计数, 数组 result 用来保存排序后的结构
 * 2. 统计 origin 元素的个数并用 counter 来保存, counter 保存的 index 就是 origin 元素的大小值
 * 3. 计算 counter 的累计值, 即 count[i] = count[i] + count[i -1], 累计值 = 本身 + 前一个值
 * 4. 根据 counter 的累计值, 转移 origin 的元素到 result 中, 每转移一个 counter 累计值减 1
 * @author liangwenqi
 * @date 2024/7/29
 */
public class P07CounterSort {

    public static void main(String[] args) {
        testCounterSort();
    }

    private static void testCounterSort() {
        int[] origin = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] result = new int[origin.length];
        int maxNum = 5;

        counterSort(origin, result, maxNum);

        System.out.println("origin: " + Arrays.toString(origin) + " => result : " + Arrays.toString(result));
        System.out.println();
    }

    public static void counterSort(int[] origin, int[] result, int maxNum) {
        if (maxNum < 0) {
            throw new RuntimeException("计数排序, 仅支持正整数排序");
        }

        // 初始化
        int[] counter = new int[maxNum + 1];

        // 开始统计数量
        // 比如: origin = {2, 5, 3, 0, 2, 3, 0, 3}
        // 统计数量之后 counter = {2, 0, 2, 3, 0, 1} = 0:2, 1:0, 2:2, 3:3, 4:0, 5:1, 下标:数量, 长度 = maxNum + 1 = 6
        for (int i = 0; i < origin.length; i++) {
            counter[origin[i]] = counter[origin[i]] + 1;
        }

        // 开始统计 counter 累计数量， 执行完以下代码后， counter[origin[i]] 保存着为小于等于 origin[i] 的个数
        // 比如： origin = {2, 5, 3, 0, 2, 3, 0, 3}, 小于等于 3 的元素是： {2, 3, 0, 2, 3, 0, 3} 共 7 个, 那么: counter[3] = counter[2] + count[3] = 7
        for (int i = 1; i < counter.length; i++) {
            counter[i] = counter[i - 1] + counter[i];
        }

        System.out.println("counter: " + Arrays.toString(counter));

        // 已知: origin = {2, 5, 3, 0, 2, 3, 0, 3}, counter = {2, 2, 4, 7, 7, 8}
        // 开始排序: 根据 counter 计数, 将 origin 的元素, 由 counter 得到的下标, 转移到 result 中
        // 比如: origin[2] = 3  -> counter[3] = 4 -> result[4] = 3
        // 相当于 count[3] 的值用作 result 的下标, 值为 origin[2]
        for (int num : origin) {
            result[counter[num] - 1] = num;
            // origin 挪动元素到 result 后, 对应的计算器要减 1
            counter[num] = counter[num] - 1;
        }
    }
}
