package com.wenqi.example;

/**
 * 辗转相处法求最大公约数
 * <p>
 * 最大数 - 最小数 直到两个数相等
 *
 * @author Wenqi Liang
 * @date 2022/10/6
 */
public class GreatestCommonDivisorTest {
    public static void main(String[] args) {
        // Greatest common divisor
        System.out.println(greatestCommonDivisor());
    }

    /**
     * 欧几米德算法 - 辗转相除法 求最大公约数
     * 最大数 - 最小数 直到两个数相等
     */
    private static int greatestCommonDivisor() {
        int a = 15;
        int b = 37;

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
