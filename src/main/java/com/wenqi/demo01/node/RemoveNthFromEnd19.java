package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/2/2
 */
public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        // [1,2,6,3,4,5,6]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                null
                                        )
                                )
                        )
                )
        );
        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 快慢指针，俩指针相隔n个节点
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 统计节点长度
        int size = 1;
        ListNode point = head;
        while (point.next != null) {
            size++;
            point = point.next;
        }

        // 删除指定index
        int index = size - n - 1;
        if (index < 0) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;

        return head;
    }
}
