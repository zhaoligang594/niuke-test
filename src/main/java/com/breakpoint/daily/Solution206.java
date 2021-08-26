package com.breakpoint.daily;

import com.breakpoint.utils.ListNode;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/23
 */
public class Solution206 {

    // 反转链表
    public ListNode reverseList(ListNode head) {
        // 返回节点
        ListNode res = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = res.next;
            res.next = head;
            head = next;
        }
        return res.next;
    }
}