package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/30
 */
public class ReverseList206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        ListNode point = head.next;
        while (point != null) {
           head.next = temp;
           temp = head;
           head = point;
           point = point.next;
        }
        head.next = temp;
        return head;
    }
}
