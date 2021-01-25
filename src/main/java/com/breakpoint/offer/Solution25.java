package com.breakpoint.offer;

import com.breakpoint.utils.ListNode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-11
 */
public class Solution25 {

    public static void main(String[] args) {

    }

    /**
     * 俩个链表的合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return res.next;
    }

}
