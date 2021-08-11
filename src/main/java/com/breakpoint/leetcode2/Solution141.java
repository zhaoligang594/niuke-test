package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.ListNode;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
@Success
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (null != fast && null != fast.next && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}
