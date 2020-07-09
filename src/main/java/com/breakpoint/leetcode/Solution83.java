package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution83 {
    /*

            给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

                示例 1:

                输入: 1->1->2
                输出: 1->2
                示例 2:

                输入: 1->1->2->3->3
                输出: 1->2->3
                通过次数112,023提交次数221,161

                来源：力扣（LeetCode）
                链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
                著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3};
        ListNode head = LinkListUtils.getListNodeByArray(arr);
        ListNode listNode = new Solution83().deleteDuplicates(head);
        System.out.println(listNode);
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        ListNode pre = head, cur = head.next;
        while (null != cur) {
            while (null != cur && cur.val == pre.val) cur = cur.next;
            pre.next = cur;
            pre = cur;
            if (null != cur) cur = cur.next;
        }
        return head;
    }
}

