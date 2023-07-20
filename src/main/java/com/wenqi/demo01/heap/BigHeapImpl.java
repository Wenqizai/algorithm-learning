package com.wenqi.demo01.heap;

/**
 * @author liangwenqi
 * @date 2023/7/20
 */
public class BigHeapImpl implements Heap {
    /**
     * 存储数组, 从下标1开始存储数据
     */
    private int[] a;
    /**
     * 堆可以存储的最大数据个数
     */
    private int n;
    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public BigHeapImpl(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 堆添加元素
     * 1. 先添加到最后
     * 2. 比较父节点, 若子节点大于父节点, 则交换位置
     */
    @Override
    public void insert(int data) {
        // 堆满了
        if (count >= n) {
            return;
        }
        ++count;
        // 放置最后位置
        a[count] = data;

        // 开始堆化, 自下往上
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // 子节点大于父节点时, 需要交互两者位置, 自下向上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 删除堆顶数据, 删除完元素之后, 要进行一遍堆化
     */
    @Override
    public void removeMax() {
        // 堆中无元素
        if (count == 0) {
            return;
        }
        // 替换堆顶元素, 这样的话, 堆化的是否只用堆顶的left 或者 right进行堆化就行(谁大就堆化哪一边)
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    /**
     * 从第一个非子节点开始建堆, index = n / 2
     *
     * 建堆从下往上依次建堆, 即 index --
     * 因为 n / 2 时最低层的非子节点, 逐渐往上堆化时, 低层的先堆化, 到堆顶堆化时, 即 index = 1, 就可以完整构建堆
     */
    @Override
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆排序:
     * 1. 先堆化, 意味着堆顶为最大元素
     * 2. 交换堆顶元素到最后的位置n
     * 3. 剩下的元素 n - 1 个, 进行堆化后重复步骤2
     *
     * 思路: 堆化后不断移除堆顶元素, 即可完成排序
     */
    @Override
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        while (n > 1) {
            swap(a, n, 1);
            n--;
            heapify(a, n, 1);
        }
    }

    /**
     * 堆化, 自上往下堆化
     *
     * 堆顶 i 与 left i * 2 和 right i * 2 + 1进行对比
     * 找出left和right中最大的元素, 替换堆顶元素
     *
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }

    /**
     * 交换index1和index2位置的元素
     */
    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
