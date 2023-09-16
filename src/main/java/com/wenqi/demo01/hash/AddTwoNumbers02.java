package com.wenqi.demo01.hash;


/**
 * @author Wenqi Liang
 * @date 9/16/2023
 */
public class AddTwoNumbers02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 解答成功:
     * 	执行耗时:1 ms,击败了100.00% 的Java用户
     * 	内存消耗:42 MB,击败了65.82% 的Java用户
     */
    private static ListNode getListNode3(ListNode l1, ListNode l2) {
        int plus = 0;

        ListNode res = l1;
        while (l1.next != null) {
            int val1 = l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + plus;

            l1.val = sum % 10;
            plus = sum / 10;

            if (l2 != null) {
                l2 = l2.next;
            }
            l1 = l1.next;
        }

        // l1 == l2
        if (l2 == null) {
            int sum = l1.val + plus;
            l1.val = sum % 10;
            plus = sum / 10;
            if (plus > 0) {
                l1.next = new ListNode(plus);
            }
        } else {
            // l1 < l2
            l1.val += plus;
            while (l2 != null) {
                int sum = l1.val + l2.val;
                l1.val = sum % 10;
                plus = sum / 10;
                if (plus == 0 && l2.next == null) {
                    break;
                }
                l1.next = new ListNode(plus);
                l1 = l1.next;
                l2 = l2.next;
            }

        }

        return res;
    }


    /**
     * 解答成功:
     * 	执行耗时:1 ms,击败了100.00% 的Java用户
     * 	内存消耗:42 MB,击败了68.23% 的Java用户
     */
    private static ListNode getListNode01(ListNode l1, ListNode l2) {
        int plus = 0;

        ListNode res = l1;
        while (l1.next != null) {
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }

            int val1 = l1.val;
            int val2 = l2.val;

            int sum = val1 + val2 + plus;

            l1.val = sum % 10;
            plus = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        // l1 == l2
        if (l2.next == null) {
            int sum = l1.val + l2.val + plus;
            l1.val = sum % 10;
            plus = sum / 10;
            if (plus > 0) {
                l1.next = new ListNode(plus);
            }
        } else {
            // l1 < l2
            l1.val += plus;
            while (l2 != null) {
                int sum = l1.val + l2.val;
                l1.val = sum % 10;
                plus = sum / 10;
                if (plus == 0 && l2.next == null) {
                    break;
                }
                l1.next = new ListNode(plus);
                l1 = l1.next;
                l2 = l2.next;
            }

        }

        return res;
    }
}

class ListNode {
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
