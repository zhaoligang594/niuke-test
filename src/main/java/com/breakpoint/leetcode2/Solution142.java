package com.breakpoint.leetcode2;

import com.breakpoint.utils.ListNode;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if(fast!=null&&fast.next != null && fast.next.next != null){
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
