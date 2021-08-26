package com.breakpoint.daily;

import com.breakpoint.utils.ListNode;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/23
 */
public class Solution876 {

    // 求解中点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
