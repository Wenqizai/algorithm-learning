package com.wenqi.book.algorithmintroduction.sort;

import java.util.Arrays;

/**
 * 基于最大堆实现的优先队列
 * 优化方向: 1. 数组扩缩容依赖指针而不是新的数组
 *
 * @author liangwenqi
 * @date 2024/7/22
 */
public class P04PriorityQueue {
    private static int[] QUEUE = new int[0];
    private static int SIZE = 0;

    public static void main(String[] args) {
        //testMaximum();
        //testInsert();
        testExtractMaxValue();
    }

    /**
     * 10 -> 8 -> 6 -> 5 -> 4 -> 3 -> 1
     */
    private static void testExtractMaxValue() {
        prepareData();
        int length = QUEUE.length;
        for (int i = 0; i < length; i++) {
            System.out.println("extract => " + extractMaxValue());
            System.out.println("exist => " + Arrays.toString(QUEUE));
            System.out.println();
        }
    }

    /**
     * insert => [10, 6, 8, 3, 5, 1, 4]
     */
    private static void testInsert() {
        prepareData();
        System.out.println("insert => " + Arrays.toString(QUEUE));
    }

    /**
     * 测试获取最大值
     */
    private static void testMaximum() {
        System.out.println(maximum());
    }


    /**
     * 将元素插入优先队列中
     */
    public static void insert(int value) {
        if (value < 0) {
            return;
        }
        expandQueue();
        if (SIZE == 0) {
            QUEUE[0] = value;
        } else {
            QUEUE[QUEUE.length - 1] = Integer.MIN_VALUE;
            increaseValue(QUEUE.length - 1, value);
        }
        SIZE++;
    }

    /**
     * 返回优先队列中最优先的元素
     */
    public static int maximum() {
        if (SIZE == 0) {
            return -1;
        }
        return QUEUE[0];
    }

    /**
     * 提取优先队列中最优先的元素, 剩余元素重新构造堆
     */
    public static int extractMaxValue() {
        int maxValue = QUEUE[0];
        // 堆化
        QUEUE[0] = QUEUE[QUEUE.length - 1];
        shrinkQueue();
        maxHeapify(0);
        SIZE--;
        return maxValue;
    }

    /**
     * 指定的 index 元素的值替换成 value, 并重新构造堆
     */
    public static void increaseValue(int index, int value) {
        if (value < 0) {
            return;
        }

        if (index >= QUEUE.length) {
            return;
        }

        int oldValue = QUEUE[index];
        QUEUE[index] = value;
        // 替换的值大于现在的值, 需要向上查找堆化
        if (oldValue < value) {
            while (index > 0) {
                int parent = parentIndex(index);
                if (QUEUE[parent] >= QUEUE[index]) {
                    break;
                }
                int temp = QUEUE[parent];
                QUEUE[parent] = QUEUE[index];
                QUEUE[index] = temp;
                index = parent;
            }
        } else if (oldValue > value) {
            // 替换的值大于现在的值, 需要向下查找堆化
            maxHeapify(index);
        }

    }

    /**
     * 堆化
     */
    private static void maxHeapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int length = QUEUE.length;
        int large = index;
        if (left < length && QUEUE[left] > QUEUE[index]) {
            large = left;
        }

        if (right < length && QUEUE[right] > QUEUE[large]) {
            large = right;
        }

        if (large != index) {
            int temp = QUEUE[index];
            QUEUE[index] = QUEUE[large];
            QUEUE[large] = temp;

            maxHeapify(large);
        }

    }

    private static void prepareData() {
        insert(10);
        insert(5);
        insert(1);
        insert(3);
        insert(6);
        insert(8);
        insert(4);
    }

    private static void shrinkQueue() {
        int[] newQueue = new int[QUEUE.length - 1];
        System.arraycopy(QUEUE, 0, newQueue, 0, newQueue.length);
        QUEUE = newQueue;
    }

    private static void expandQueue() {
        int[] newQueue = new int[QUEUE.length + 1];
        System.arraycopy(QUEUE, 0, newQueue, 0, QUEUE.length);
        QUEUE = newQueue;
    }

    /**
     * 由子节点获取父节点的索引, 子节点有两种情况, 左节点, 右节点
     * 左节点: index / 2 , 奇数
     * 右节点: index / 2  - 1, 偶数
     */
    private static int parentIndex(int index) {
        if (index == 0) {
            return index;
        }
        if (index % 2 != 0) {
            return index / 2;
        }
        return index / 2 - 1;
    }

    /**
     * 性能更优的实现, 获取父节点的索引
     */
    private static int parentIndex2(int index) {
        if (index == 0) {
            return 0;
        }
        return (index - 1) / 2;
    }

}
