package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/30
 */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode temp = start;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return start.next;
    }
}
