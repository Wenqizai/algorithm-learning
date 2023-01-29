package com.wenqi.demo01.node;

/**
 * @author liangwenqi
 * @date 2023/1/28
 */
public class MyLinkedList707 {

    private ListNode head;
    private int size;

    public MyLinkedList707() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        ListNode temp = head.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }
        ListNode node = new ListNode(val);
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        if (index == 0) {
            // 删除头节点
            head.next = head.next.next;
        } else {
            ListNode temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
}
