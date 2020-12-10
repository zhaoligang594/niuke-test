package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/10/13
 */
public class Solution445 {

    public static void main(String[] args) {
        int[] list1 = {7, 2, 4, 3};
        int[] list2 = {5, 6, 4};
        ListNode l1 = LinkListUtils.getListNodeByArray(list1);
        ListNode l2 = LinkListUtils.getListNodeByArray(list2);
        ListNode node = new Solution445().addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null;

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int tmp = stack1.pollLast() + stack2.pollLast() + carry;
            carry = tmp / 10;
            ListNode node = new ListNode(tmp % 10);
            node.next = res;
            res = node;
        }
        while (!stack1.isEmpty()) {
            int tmp = stack1.pollLast() + carry;
            carry = tmp / 10;
            ListNode node = new ListNode(tmp % 10);
            node.next = res;
            res = node;
        }
        while (!stack2.isEmpty()) {
            int tmp = stack2.pollLast() + carry;
            carry = tmp / 10;
            ListNode node = new ListNode(tmp % 10);
            node.next = res;
            res = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = res;
            res = node;
        }
        return res;
    }
}
