package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * middle
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution82 {
    /*
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

        示例 1:

        输入: 1->2->3->3->4->4->5
        输出: 1->2->5
        示例 2:

        输入: 1->1->1->2->3
        输出: 2->3
        通过次数63,788提交次数130,188

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
             */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4};
        ListNode head = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution82().deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null==head||head.next == null) return head;
        ListNode cur = head, next = head.next, pre = head, temp;
        while (next != null) {
            if (cur.val == next.val) {
                temp = next;
                while (next != null && temp.val == next.val) next = next.next;
                if (cur == head) {
                    head = next;
                    cur = next;
                    pre = next;
                } else {
                    pre.next = next;
                }
            }

            if (null != pre && pre.next == cur) pre = cur;
            cur = next;
            if (null != next) next = next.next;

        }
        return head;
    }
}
