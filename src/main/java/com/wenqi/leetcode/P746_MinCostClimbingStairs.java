package com.wenqi.leetcode;

import java.util.Arrays;

/**
 * leetCode 746: 最小费用爬楼梯
 * 动态规划 5 部曲:
 * 1. dp 数组及其下标含义
 * 2. 初始化 dp 数组
 * 3. 递推公式
 * 4. 遍历顺序
 * 5. 打印结果 dp 数组
 *
 * @author liangwenqi
 * @date 2024/12/19
 */
public class P746_MinCostClimbingStairs {
    public static void main(String[] args) {
        //System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        //System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));


        //System.out.println(minCostClimbingStairsNoDp(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairsNoDp(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }


    /**
     * 无 dp 数组解法: 使用变量存储前后关联值
     */
    public static int minCostClimbingStairsNoDp(int[] cost) {
        int minCost1 = 0;
        int minCost2 = 0;
        int minCost = 0;
        //int[] dp = new int[cost.length];
        //dp[0] = minCost1;
        //dp[1] = minCost2;
        for (int i = 2; i < cost.length; i++) {
            minCost2 = minCost1;
            minCost1 = minCost;
            minCost = Math.min(minCost1 + cost[i - 1], minCost2 + cost[i - 2]);

            //dp[i] = minCost;
        }
        //System.out.println("print dp: " + Arrays.toString(dp));
        minCost2 = minCost1;
        minCost1 = minCost;
        return Math.min(minCost1 + cost[cost.length - 1], minCost2 + cost[cost.length - 2]);
    }


    /**
     * 标准解法, dp 数组.
     * 调优: 去掉 dp 数据, 仅存储与第 i 级台阶关联的 i - 1 和 i - 2 的最小费用
     */
    public static int minCostClimbingStairs(int[] cost) {
        // dp 存储迈到该台阶的最小费用
        int[] dp = new int[cost.length];

        // 迈到 0 级台阶的最小费用 0, 迈 1 步到达
        dp[0] = 0;
        // 迈到 1 级台阶的最小费用 0, 迈 2 步到达
        dp[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            // dp[i]: 代表从迈到 i 级台阶最小费用:
            // 1. 迈 1 步到 i 级台阶最小费用 = 迈到 (i - 1) 台阶的最小费用加上 i - 1 台阶的费用
            // 2. 迈 2 步到 i 级台阶最小费用 = 迈到 (i - 2) 台阶的最小费用加上 i - 2 台阶的费用
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        System.out.println("print dp: " + Arrays.toString(dp));

        return Math.min(dp[cost.length - 2] + cost[cost.length - 2], dp[cost.length - 1] + cost[cost.length - 1]);
    }
}
