package com.wenqi.example;

/**
 * 小明去附近的水果店买橙子，水果商贩只提供整袋购买，有每袋6个和每袋8个的包装（包装不可拆分）。
 * 可是小明只想购买恰好n个橙子，并且尽量少的袋数方便携带。如果不能购买恰好n个橙子，小明将不会购买
 * 请根据此实现一个程序，要求：
 * <p>
 * 输入一个整数n，表示小明想要购买n（1≤n≤100）个橙子
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个橙子则输出-1
 * 例如，输入20，输出3。
 *
 * @author liangwenqi
 * @date 2024/12/10
 */
public class OrangeTest {

    public static void main(String[] args) {
        System.out.println(buy(20));
    }


    private static int buy(int n) {
        int a = 6;
        int b = 8;

        int aTimes = n / a + 1;
        int bTimes = n / b + 1;

        int minTimes = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i <= aTimes; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j <= bTimes; j++) {
                int buy = i * a + j * b;
                if (buy >= 20) {
                    minTimes = Math.min(i + j,  minTimes);
                    if (buy % n == 0) {
                        found = true;
                    }
                    break;
                }
            }
        }

        return found ? minTimes : -1;
    }

}
