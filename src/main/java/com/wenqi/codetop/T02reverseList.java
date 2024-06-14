package com.wenqi.codetop;

/**
 * @author liangwenqi
 * @date 2024/6/13
 */
public class T02reverseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;


        ListNode  reverseNode = reverseList(n1);
        System.out.println(reverseNode);
    }


    public static ListNode reverseList02(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
       ListNode res = head;
       ListNode dummy = null;
       while (head.next != null) {
           head = head.next;
           res.next = dummy;
           dummy = res;
           res = head;
       }
       res.next = dummy;
       return res;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
