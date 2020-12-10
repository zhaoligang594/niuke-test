package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.*;

/**
 * 1019. 链表中的下一个更大节点
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution1019 {

    public static void main(String[] args) {
        int[] nums = {1,7,5,1,9,2,5,1};
        ListNode head = LinkListUtils.getListNodeByArray(nums);
        int[] ints = new Solution1019().nextLargerNodes(head);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] integers = list.toArray(new Integer[0]);
        int[] res = new int[integers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < integers.length; i++) {
            if (!stack.isEmpty() && integers[stack.peekLast()] >= integers[i]) {
                stack.addLast(i);
            } else if (!stack.isEmpty() && integers[stack.peekLast()] < integers[i]) {
                while (!stack.isEmpty() && integers[stack.peekLast()] < integers[i]) {
                    res[stack.pollLast()] = integers[i];
                }
                stack.addLast(i);
            }
        }
        return res;
    }


}
