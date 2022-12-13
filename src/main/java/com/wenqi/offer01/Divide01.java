package com.wenqi.offer01;

/**
 * @author liangwenqi
 * @date 2022/7/19
 */
public class Divide01 {

    public static void main(String[] args) {
        System.out.println(divide2(1026117192, -874002063));
        //System.out.println(divide2(Integer.MIN_VALUE, -1));
    }

    public static int divide(int a, int b) {
        // -1073741824
        int minLimit = Integer.MIN_VALUE >> 1;
        if (a == Integer.MIN_VALUE && b == -1) {
            // 特判
            return Integer.MAX_VALUE;
        }
        boolean isPos = (a >= 0 || b <= 0) && (a <= 0 || b >= 0);
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        // 最终的商
        int ans = 0;
        while (a <= b) {
            // d为当前除数，c为当前商
            int d = b;
            int c = 1;
            // 通过第一个条件防止d + d溢出
            while (d >= minLimit && d + d >= a) {
                // 当前除数倍增，也可以用 d <<= 1
                d += d;
                // 当前商倍增，也可以用 c <<= 1
                c += c;
            }
            // a剩余部分
            a -= d;
            // 累计当前商
            ans += c;
        }
        return isPos ? ans : -ans;
    }


    /**
     * 超出时间限制, 考虑倍数减法, 提高运算效率
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide2(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        } else if (a == 0) {
            return 0;
        }

        if (b == Integer.MIN_VALUE) {
            if (a == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            ans = -1;
        }

        int aV = 0;
        if (a == Integer.MIN_VALUE) {
            a = Integer.MIN_VALUE + 1;
            aV = 1;
        }

        int limit = Integer.MAX_VALUE >> 2;
        int count = 0;
        int positA = Math.abs(a);
        int positB = Math.abs(b);
        if (positA - positB == 0) {
            return ans;
        }
        positA = positA - positB + aV;
        if (positA == Integer.MAX_VALUE) {
            return ans == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (positA >= 0) {
            count++;
        }

        while (positA >= positB) {
            int c = 1;
            while ((positB <= limit) && (positB + positB < positA)) {
                positB += positB;
                c += c;
            }
            positA -= positB;
            count += c;
        }

        return ans == -1 ? -count : count;
    }
}
