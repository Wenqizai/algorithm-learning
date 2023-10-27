package com.wenqi.geektime.backtracking;

/**
 * 8皇后问题:
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 *
 * @author liangwenqi
 * @date 2023/10/27
 */
public class EightQueen {
    public static void main(String[] args) {
        cal8queens(0);
    }


    /**
     * 保存结果, index: row; value: column
     */
    private static int[] result = new int[8];

    public static void cal8queens(int row) {
        if (row == 8) {
            //System.out.println("done : " + Arrays.toString(result));
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private static boolean isOk1(int row, int column) {// 判断 row 行 column 列放置是否合适
        int leftup = column - 1, rightup = column + 1;

        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) { // 考察左上对角线
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) { // 考察右上对角线
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }

        return true;
    }

    /**
     * 等腰三角形，高步增 1
     * 保持 column 不变
     */
    private static boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            // 往上找
            if (result[i] == column) {
                return false;
            }

            // 左对角线找
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }

            // 有对角线找
            if (rightUp < 8 && result[i] == rightUp) {
                return false;
            }

            leftUp--;
            rightUp++;
        }
        return true;
    }


    private static void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
