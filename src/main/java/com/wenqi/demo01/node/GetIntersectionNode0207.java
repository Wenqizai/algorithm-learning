package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/4/12
 */
public class GetIntersectionNode0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            if (node2 == null) {
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        boolean aFlag = node1 == null;
        ListNode temp = aFlag ? node2 : node1;

        node1 = headA;
        node2 = headB;

        while (temp != null) {
            if (aFlag) {
                node2 = node2.next;
            } else {
                node1 = node1.next;
            }
            temp = temp.next;
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    private ListNode getListNode2(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

    private ListNode getListNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (headA.next != null) {
            while (node2.next != null) {
                node2 = node2.next;
                if (node1 == node2) {
                    return node1;
                }
            }
            node1 = node1.next;
            node2 = headB;
        }
        return null;
    }
}
