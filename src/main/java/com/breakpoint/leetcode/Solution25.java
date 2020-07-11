package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 * @see Solution24
 */
public class Solution25 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNodeByArray = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution25().reverseKGroup(listNodeByArray, 3);
        System.out.println(listNode);
    }


    // 转变k组
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode res = null, cur = null;

        Stack<ListNode> stack = new Stack<>();


        while (null != head) {
            ListNode temp = head;
            while (null != temp) {
                stack.push(temp);
                temp = temp.next;
                if (stack.size() == k) {
                    head = temp;
                    break;
                }
            }

            if (stack.size() < k) {
                cur.next = head;
                cur = stack.peek();
                stack.clear();
                head = null;
            }

            while (!stack.isEmpty()) {
                if (null == res) {
                    res = stack.pop();
                    cur = res;
                } else {
                    cur.next = stack.pop();
                    cur = cur.next;
                }
            }
        }

        if (cur != null) {
            cur.next = null;
        }

        return res;

    }
}
