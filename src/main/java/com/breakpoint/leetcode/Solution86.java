package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/26
 */
public class Solution86 {
    /*
        给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

        你应当保留两个分区中每个节点的初始相对位置。

        示例:

        输入: head = 1->4->3->2->5->2, x = 3
        输出: 1->2->2->4->3->5
        通过次数49,637提交次数83,573

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/partition-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */
    public static void main(String[] args) {
        int[] array = {3,1,2};
        ListNode head = LinkListUtils.getListNodeByArray(array);
        ListNode partition = new Solution86().partition(head, 3);
        System.out.println(partition);
    }

    public ListNode partition(ListNode head, int x) {
        if (null == head || head.next == null) return head;

        ListNode pre = head, cur = head.next, ops;

        if (pre.val < x) {
            while (null != cur && cur.val < x) {
                pre = cur;
                cur = cur.next;
            }
        }

        if (head == pre && pre.val >= x) {
            ops = null;
        } else {
            ops = pre;
        }

        // 上面是找到了第一个比>=x的位置


        while (cur != null) {
            if (cur.val < x) {
                if (ops != null) {
                    pre.next = cur.next;
                    cur.next = ops.next;
                    ops.next = cur;
                    cur = pre.next;
                    ops = ops.next;
                } else {
                    pre.next = cur.next;
                    ops = cur;
                    ops.next = head;
                    head = ops;
                    cur = pre.next;
                }

            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
