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

    // 去掉重复的，仅仅保留一个的操作
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dumpy = new ListNode(-101), cur = dumpy;
        dumpy.next = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dumpy.next;
    }

    // 去掉重复的 不保留任何的重复的数据
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpy = new ListNode(-101), cur = head, pre = dumpy;
        dumpy.next = head;
        while (null != cur && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
                while (cur != null && cur.val == pre.next.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dumpy.next;
    }
}
