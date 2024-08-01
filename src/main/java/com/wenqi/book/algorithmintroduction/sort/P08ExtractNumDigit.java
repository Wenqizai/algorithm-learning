package com.wenqi.book.algorithmintroduction.sort;

/**
 * @author liangwenqi
 * @date 2024/8/1
 */
public class P08ExtractNumDigit {
    public static void main(String[] args) {
        //testExtractNumDigitMatch();
        testExtractNumDigitHigh();
    }

    private static void testExtractNumDigitMatch() {
        int num = 12343;
        int maxDigit = 5;
        for (int i = 1; i <= maxDigit; i++) {
            System.out.println(extractNumDigit(num, i));
        }
    }

    private static void testExtractNumDigitHigh() {
        int num = 12343;
        int maxDigit = 7;
        for (int i = 1; i <= maxDigit; i++) {
            System.out.println(extractNumDigit(num, i));
        }
    }

    /**
     * 用来提取数字指定位数的方法
     * 比如输入 num=12343, digit=2, 输出 result=4
     * @param num 指定数字
     * @param digit 指定位数
     */
    public static int extractNumDigit(int num, int digit) {
        // 浮点数的运算比较慢, 考虑替换 Math.pow()
        //num = (int) (num / Math.pow(10, digit - 1));
        // for 循环比使用浮点数更优
        for (int i = 1; i < digit; i++) {
            num /= 10;
        }
        return num % 10;
    }
}
