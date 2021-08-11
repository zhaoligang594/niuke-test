package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * middle
 *
 * @author :breakpoint/赵立刚
 * create on 2020/08/24
 */
@Success
public class Solution148 {

    /*
        在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

        示例 1:

        输入: 4->2->1->3
        输出: 1->2->3->4
        示例 2:

        输入: -1->5->3->4->0
        输出: -1->0->3->4->5
        通过次数85,201提交次数127,577

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sort-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};
        ListNode head = LinkListUtils.getListNodeByArray(array);
        ListNode listNode = new Solution148().sortList(head);
        System.out.println(listNode);
    }

    // 采用归并排序的方式求解这个问题
    public ListNode sortList(ListNode head) {
        if (null == head || head.next == null) return head;
        ListNode l = head, fast = head, slow = head, r = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        r = slow.next;
        slow.next = null;
        ListNode left = sortList(l);
        ListNode right = sortList(r);
        return combine(left, right);
    }

    // 合并2个有序的链表
    private ListNode combine(ListNode left, ListNode right) {
        if (left == null) return right;
        if (left == right) return left;
        ListNode res = new ListNode(-1), tail = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        if (null != left) {
            tail.next = left;
        }
        if (null != right) {
            tail.next = right;
        }
        return res.next;
    }
}
