package com.breakpoint.leetcode;

import com.breakpoint.utils.ListNode;

import java.util.Stack;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/28
 */
public class Solution234 {

    public static void main(String[] args) {

    }


    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }

        ListNode first = head, cur = head;

        Stack<ListNode> stack = new Stack<>();

        while (null != cur) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (pop.val == first.val) {
                first = first.next;
            } else {
                return false;
            }
        }


        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
