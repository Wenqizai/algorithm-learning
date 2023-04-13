package com.wenqi.demo01.node;

/**
 * @author Wenqi Liang
 * @date 2022/7/24
 */
public class RemoveElements_203 {
    public static void main(String[] args) {
        // [1,2,6,3,4,5,6]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6, null)
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
        removeElements(head, 2);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode tmp = null;
        while (head != null) {
            if (head.val != val) {
                tmp = head;
                break;
            }
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        while (head != null) {
            if (head.next == null) {
                break;
            } else if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }


    public static ListNode removeElements2(ListNode head, int val) {
        ListNode tmp = null;
        while (head != null) {
            if (head.val != val) {
                tmp = head;
                break;
            }
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }
}
