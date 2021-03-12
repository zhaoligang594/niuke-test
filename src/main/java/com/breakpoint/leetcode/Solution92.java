package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/07
 */
public class Solution92 {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        ListNode node = new Solution92().reverseBetween(head, 2, 4);
        System.out.println(node);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode res = new ListNode(1), cur = head, prev = res;
        res.next = head;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode tail = null;
        while (n > 0) {
            if (null == tail) tail = cur;
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
            n--;
        }
        if (tail != null) tail.next = cur;
        // 返回结果
        return res.next;
    }
}
