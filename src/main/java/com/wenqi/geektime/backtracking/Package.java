package com.wenqi.geektime.backtracking;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包问题:
 * 我们有一个背包,背包总的承载重量是 Wkg。现在我们有 n 个物品,每个物品的重量不等,并且不可分割。
 * 我们现在期望选择几件物品,装载到背包中。在不超过背包所能装载重量的前提下,如何让背包中物品的总重量最大？
 *
 * @author liangwenqi
 * @date 2023/10/27
 */
public class Package {
    public static void main(String[] args) {
        pack(0, 0, Lists.newArrayList(2, 2, 4, 6, 3), new ArrayList<>());
    }


    /**
     * 背包最大重量
     */
    private static int maxWeight = Integer.MIN_VALUE;
    /**
     * 要求装进背包的重量
     */
    private static int reqWeight = 9;
    /**
     * 物品数量
     */
    private static int itemCount = 5;

    /**
     * 打包
     *
     * @param carryWeight 背包已经装进去的重量
     * @param rest        剩余的物品
     */
    public static void pack(int step, int carryWeight, List<Integer> rest, List<Integer> result) {
        // 装够了重量
        if (carryWeight == reqWeight || step == itemCount) {
            System.out.println("found one :" + JSON.toJSONString(result) + "weight=" + result.stream().reduce(0, Integer::sum));
            return;
        }

        Integer item = rest.get(step);
        // 1. 不加
        pack(step + 1, carryWeight, rest, result);
        // 2. 加
        if (carryWeight <= reqWeight) {
            List<Integer> newResult = new ArrayList<>(result);
            newResult.add(item);
            carryWeight += item;
            pack(step + 1, carryWeight, rest, newResult);
        }
    }

}
