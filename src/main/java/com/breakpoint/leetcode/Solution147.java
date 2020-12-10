package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author breakpoint/赵先生
 * 2020/11/20
 */
public class Solution147 {

    public static void main(String[] args) {
        int[] list = {4, 2, 1, 3};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        ListNode node = new Solution147().insertionSortList(head);
        System.out.println(node);
    }

    public ListNode insertionSortList(ListNode head) {
        if (null == head) return head;
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        // 对于链表头的处理
        dump.next = head;
        Deque<ListNode> stack = new LinkedList<>();
        stack.addLast(dump);
        ListNode cur = dump.next, next = null, pre = null;
        while (cur != null) {
            if (next == null) {
                next = cur.next;
            }
            while (cur.val < stack.peekLast().val) {
                if (null == pre) {
                    stack.peekLast().next = next;
                }
                pre = stack.pollLast();
            }
            if (null != pre) {
                stack.peekLast().next = cur;
                cur.next = pre;
            }
            while (cur != next) {
                stack.addLast(cur);
                cur = cur.next;
            }
            cur = next;
            next=null;
            pre=null;
        }
        return dump.next;
    }
}
