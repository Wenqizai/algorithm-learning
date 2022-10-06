package com.wenqi.example;

/**
 * 求质数
 * <p>
 * 质数/素数: 一个大于 1 的正整数, 除了 1 和他本身之外, 不能被其他正整数整除, 该数就是素数.
 *
 * @author Wenqi Liang
 * @date 2022/10/6
 */
public class PrimeNumberTest {

    public static void main(String[] args) {
        int number = 59;
        System.out.println(isPrimeNumber(number) ? "是素数" : "不是素数");
        System.out.println(isPrimeNumberBetter(number) ? "是素数" : "不是素数");
    }


    private static boolean isPrimeNumber(int number) {
        if (number < 1) {
            return false;
        }

        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 开根号算法
     */
    private static boolean isPrimeNumberBetter(int number) {
        if (number <= 3) {
            return true;
        }

        int endNum = (int) Math.sqrt(number);
        for (int i = 2; i < endNum; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



}
