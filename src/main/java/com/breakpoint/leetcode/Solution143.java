package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/20
 */
public class Solution143 {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        new Solution143().reorderList(head);
        System.out.println(1);
    }

    public void reorderList(ListNode head) {
        if (head != null) {
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode temp = head, pre = null;
            while (null != temp) {
                deque.addLast(temp);
                temp = temp.next;
            }
            while (!deque.isEmpty()) {
                ListNode node = deque.pollFirst();
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    if (deque.isEmpty()) pre = pre.next;
                }
                if (!deque.isEmpty()) {
                    ListNode last = deque.pollLast();
                    node.next = last;
                    pre = last;
                }
            }
            pre.next = null;
        }
    }
}
