package com.wenqi.example;

/**
 * 鸡兔同笼问题:
 * <p>
 * x + y = 10
 * 2x + 4y = 32
 *
 * @author Wenqi Liang
 * @date 2022/10/6
 */
public class XYTest {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        boolean flag = false;
        while (x < 10) {
            y = 10 - x;
            int temp = 2 * x + 4 * y;
            if (temp == 32) {
                flag = true;
                break;
            }
            x++;
        }
        if (flag) {
            System.out.println("x -> " + x + ", y -> " + y);
        } else {
            System.out.println("无解");
        }
    }
}
