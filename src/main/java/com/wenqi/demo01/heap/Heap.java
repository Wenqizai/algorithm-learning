package com.wenqi.demo01.heap;

/**
 * @author liangwenqi
 * @date 2023/7/20
 */
public interface Heap {
    /**
     * 堆添加元素
     */
    void insert(int data);

    /**
     * 删除堆顶数据
     */
    void removeMax();

    /**
     * 建堆
     * a : 数组原地建堆
     * n : 最大堆的个数
     */
    void buildHeap(int[] a, int n);

    /**
     * 堆排序
     */
    void sort(int[] a, int n);
}
