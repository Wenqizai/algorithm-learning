package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/30
 */
public class SwapPairs24 {
    public static void main(String[] args) {
        SwapPairs24 swapPairs24 = new SwapPairs24();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        swapPairs24.swapPairs(head);
    }

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

    public ListNode swapPair2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);

        int step = 1;

        ListNode prePre = dummyHead;
        ListNode pre = head;
        prePre.next = pre;
        ListNode p = head.next;

        while (p != null) {
            ListNode pNextTmp = p.next;
            if (step % 2 == 1) {
                prePre.next = p;
                p.next = pre;
                pre.next = pNextTmp;

                prePre = p;
            } else {
                prePre = pre;
                pre = p;
            }
            p = pNextTmp;
            step++;
        }

        return dummyHead.next;
    }
}
