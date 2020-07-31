package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution141 {



    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        ListNode listNodeByArray = LinkListUtils.getListNodeByArray(nums, 1);
        boolean b = new Solution141().hasCycle(listNodeByArray);
        System.out.println(b);

    }

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {
            return false;
        }
        ListNode fast = head, low = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
        }
        return false;
    }
}