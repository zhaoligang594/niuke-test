package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 206. 反转链表
 * simple
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/31
 */
public class Solution206 {


    /*
            反转一个单链表。

            示例:

            输入: 1->2->3->4->5->NULL
            输出: 5->4->3->2->1->NULL
            进阶:
            你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-linked-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {1};
        ListNode listNodeByArray = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution206().reverseList(listNodeByArray);
        LinkListUtils.printLinkList(listNode);
    }



    public ListNode reverseList(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode cur = head.next, next;
        head.next = null;
        while (null != cur) {
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
}
