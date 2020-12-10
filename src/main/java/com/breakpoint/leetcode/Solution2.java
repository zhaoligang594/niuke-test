package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/04
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] num1 = {2, 4, 9};
        int[] num2 = {5, 6, 4, 9};
        ListNode l1 = LinkListUtils.getListNodeByArray(num1);
        ListNode l2 = LinkListUtils.getListNodeByArray(num2);
        ListNode node = new Solution2().addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode res = null, cur = null;
        int up = 0;
        while (null != l1 && null != l2) {
            int temp = l1.val + l2.val + up;
            ListNode node = new ListNode(temp % 10);
            up = temp / 10;
            if (null == res) {
                res = node;
                cur = res;
            } else {
                cur.next = node;
                cur = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1) {
            int temp = l1.val + up;
            ListNode node = new ListNode(temp % 10);
            up = temp / 10;
            cur.next = node;
            cur = node;
            l1 = l1.next;
        }
        while (null != l2) {
            int temp = l2.val + up;
            ListNode node = new ListNode(temp % 10);
            up = temp / 10;
            cur.next = node;
            cur = node;
            l2 = l2.next;
        }
        if (up > 0) {
            ListNode node = new ListNode(up);
            cur.next = node;
        }
        return res;
    }
}
