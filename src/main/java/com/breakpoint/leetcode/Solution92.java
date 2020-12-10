package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/07
 */
public class Solution92 {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        ListNode node = new Solution92().reverseBetween(head, 2, 4);
        System.out.println(node);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode  prev = null, cur = head;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = cur;
        ListNode third = null;
        // 主要看 我们的 大小 以及 如何的操作我们的链表
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null || head.next == null) return head;
//        ListNode res = null, opt = null, pre = null, cur = null;
//        int k = 1;
//        if (m != 1) {
//            opt = head;
//            pre = head;
//            cur = pre.next;
//            while (k < m - 1) {
//                pre = pre.next;
//                cur = pre.next;
//                opt=opt.next;
//                k++;
//            }
//        } else {
//            cur = head;
//        }
//
//        if (opt == null) {
//            ListNode tail = null;
//            while (k <= n) {
//                if (opt == null) {
//                    opt = cur;
//                    //opt.next=null;
//                    cur = cur.next;
//                    if (null == tail) tail = opt;
//                } else {
//                    ListNode temp = cur.next;
//                    cur.next = opt;
//                    opt = cur;
//                    cur = temp;
//                }
//                k++;
//            }
//            tail.next = cur;
//        } else {
//            while (k < n) {
//                pre.next = cur.next;
//                cur.next = opt.next;
//                opt.next = cur;
//                if (pre == opt) {
//                    pre = pre.next;
//                }
//                cur = pre.next;
//                k++;
//            }
//        }
//        if (m == 1) {
//            res = opt;
//        } else {
//            res = head;
//        }
//        return res;
//    }
}
