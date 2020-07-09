package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * hard
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution23 {

    public static void main(String[] args) {

        int[] list1Nums = {1, 4, 5};
        int[] list2Nums = {1, 3, 4};
        int[] list3Nums = {2, 6};

        ListNode[] listNodes = new ListNode[3];

        listNodes[0] = LinkListUtils.getListNodeByArray(list1Nums);
        listNodes[1] = LinkListUtils.getListNodeByArray(list2Nums);
        listNodes[2] = LinkListUtils.getListNodeByArray(list3Nums);

        // merge
        ListNode listNode = new Solution23().mergeKLists(listNodes);

        System.out.println(listNode);

    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else {
            int len = lists.length;
            int middle = len / 2;
            while (middle >= 1) {
                for (int i = 0; i < middle; i++) {
                    lists[i] = mergeTwoLists(lists[i], lists[len - i - 1]);
                }
                len = len % 2 == 0 ? len / 2 : len / 2 + 1;
                middle = len / 2;
            }
            return lists[0];
        }
    }


    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = null, cur = null;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                if (null == head) {
                    head = l1;
                    cur = head;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (null == head) {
                    head = l2;
                    cur = head;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }

        if (null != l1) {
            cur.next = l1;
        }

        if (null != l2) {
            cur.next = l2;
        }

        return head;
    }
}
