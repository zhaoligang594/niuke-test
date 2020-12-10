package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 61. 旋转链表
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution61 {
    /*
        给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

        示例 1:

        输入: 1->2->3->4->5->NULL, k = 2
        输出: 4->5->1->2->3->NULL
        解释:
        向右旋转 1 步: 5->1->2->3->4->NULL
        向右旋转 2 步: 4->5->1->2->3->NULL
        示例 2:

        输入: 0->1->2->NULL, k = 4
        输出: 2->0->1->NULL
        解释:
        向右旋转 1 步: 2->0->1->NULL
        向右旋转 2 步: 1->2->0->NULL
        向右旋转 3 步: 0->1->2->NULL
        向右旋转 4 步: 2->0->1->NULL
        通过次数82,846提交次数204,392

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/rotate-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution61().rotateRight(head, 2);
        System.out.println(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int n = 0, count = -1; // 计算
        ListNode cur = head, pre = head, res;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (n == 0) return head;
        k %= n;
        if (k == 0) return head;
        cur = head;
        while (cur != null) {
            count++;
            if (count > k) pre = pre.next;
            cur = cur.next;
        }
        cur = pre.next;
        pre.next = null;
        res = cur;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return res;
    }


}
