package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
