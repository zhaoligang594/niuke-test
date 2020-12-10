package com.breakpoint.tengxun;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author breakpoint/赵先生
 * 2020/11/29
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        ListNode node = new ReverseList().reverseList(head);
        System.out.println(node);
    }

    public int singleNumber(int[] nums) {
        int res = 0, dump = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
