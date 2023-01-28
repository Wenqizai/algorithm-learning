package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/28
 */
public class MyLinkedList707 {

    private ListNode head;
    private int length;

    public MyLinkedList707() {
        length = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index > length - 1 || head == null) {
            return -1;
        }
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        length++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            this.head = node;
            length = 1;
            return;
        }
        ListNode temp = head;
        int point = length - 1;
        while (point > 0) {
            temp = temp.next;
            point--;
        }
        temp.next = node;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index == length - 1) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > length - 1) {
            return;
        }

        if (index == 0) {
            // 删除头节点
            head = head.next;
        } else {
            ListNode temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
        }

        length--;
    }
}
