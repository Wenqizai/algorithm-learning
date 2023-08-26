package com.wenqi.demo01.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wenqi Liang
 * @date 8/26/2023
 */
public class IsHappy202 {
    public static void main(String[] args) {
        IsHappy202 isHappy202 = new IsHappy202();
        System.out.println(isHappy202.isHappy(19));
    }

    /**
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.2 MB,击败了93.35% 的Java用户
     */
    public boolean isHappy2(int n) {
        // 快慢指针, 快指针是慢指针的2倍, 当在一个循环或者一个环状结构中, 快慢指针始终会在某一时刻相遇
        // 因为快指针走过的路程是慢指针的2倍
        int fast = n;
        int slow = n;
        do {
            slow = getNextNum(slow);
            fast = getNextNum(fast);
            fast = getNextNum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private static int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int res = n % 10;
            sum += res * res;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 	执行耗时:1 ms,击败了85.70% 的Java用户
     * 	内存消耗:38.8 MB,击败了19.05% 的Java用户
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        Set<Integer> resultSet = new HashSet<>();
        while (n != 1 && !resultSet.contains(n)) {
            resultSet.add(n);
            int sum = 0;
            while (n > 0) {
                int res = n % 10;
                res *= res;
                sum += res;
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
