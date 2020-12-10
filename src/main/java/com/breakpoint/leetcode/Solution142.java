package com.breakpoint.leetcode;

import com.breakpoint.utils.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author breakpoint/赵先生
 * 2020/10/10
 */
public class Solution142 {

    public static void main(String[] args) {

    }

    /**
     * 返回入环的第一个节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast != null && fast.next != null && fast.next.next != null) {
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
