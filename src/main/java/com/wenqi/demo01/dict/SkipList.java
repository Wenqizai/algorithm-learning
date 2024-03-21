package com.wenqi.demo01.dict;

/**
 * @author liangwenqi
 * @date 2024/3/20
 */

import java.util.Random;

// 定义跳表类
public class SkipList {
    private static final double PROBABILITY = 0.5; // 控制节点层数增长的概率
    private final SkipListNode head; // 跳表头节点

    public SkipList() {
        this.head = new SkipListNode(Integer.MIN_VALUE);
    }

    /**
     * 生成随机层数
     */
    private int randomLevel() {
        int level = 0;
        Random rand = new Random();
        while (rand.nextDouble() < PROBABILITY) {
            level++;
        }
        return level;
    }

    /**
     * 插入节点
     */
    public void insert(int val) {
        int newLevel = randomLevel();
        SkipListNode newNode = new SkipListNode(val);
        SkipListNode current = head;

        SkipListNode[] update = new SkipListNode[newLevel + 1];
        for (int i = 0; i <= newLevel; i++) {
            update[i] = head;
        }

        for (int i = newLevel; i >= 0; i--) {
            while (current.next != null && current.next.val < val) {
                current = current.next;
            }
            update[i] = current;
            if (current.down != null) {
                current = current.down;
            }
        }

        for (int i = 0; i <= newLevel; i++) {
            newNode.next = update[i].next;
            update[i].next = newNode;

            if (i > 0) {
                newNode.down = update[i - 1].next;
            }
            newNode = newNode.down;
        }
    }

    /**
     * 搜索节点
     */
    public boolean search(int target) {
        SkipListNode current = head;
        while (current != null) {
            if (current.next == null || current.next.val > target) {
                current = current.down;
            } else if (current.next.val == target) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    /**
     * 打印跳表
     */
    public void printSkipList() {
        SkipListNode current = head;
        while (current != null) {
            SkipListNode temp = current;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
            current = current.down;
        }
    }

    public static class SkipListNode {
        int val;
        SkipListNode next;
        SkipListNode down;

        // 构造函数
        public SkipListNode(int val) {
            this.val = val;
            this.next = null;
            this.down = null;
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        // 插入节点
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);

        // 打印跳表
        System.out.println("打印跳表:");
        skipList.printSkipList();

        // 搜索节点
        System.out.println("搜索结果:");
        System.out.println("是否包含 3? " + skipList.search(3));
        System.out.println("是否包含 6? " + skipList.search(6));
    }
}
