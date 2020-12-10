package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/08
 */
public class Solution1171 {

    public static void main(String[] args) {
        int[] list = {1, 2, -3, 3, 1};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        ListNode node = new Solution1171().removeZeroSumSublists(head);
        System.out.println(node);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (null == head || (head.val == 0 && head.next == null)) return null;
        ListNode res = null;

        //int c




        return res;
    }
}
