package com.breakpoint.leetcode;

import com.breakpoint.utils.ListNode;

/**
 * 相交的链表
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-01
 */
public class Solution160 {

    //private static volatile

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tailA = null, tailB = null, pA = headA, pB = headB;
        int switchA = 0, switchB = 0;
        while (pA != pB) {
            if (tailA != null && tailB != null && tailB != tailA) return null;
            if (pA.next == null) {
                if (tailA == null) {
                    tailA = pA;
                }
                pA = switchHead(headA, headB, ++switchA);
            } else {
                pA = pA.next;
            }
            if (pB.next == null) {
                if (tailB == null) {
                    tailB = pB;
                }
                pB = switchHead(headB, headA, ++switchB);
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    private ListNode switchHead(ListNode headA, ListNode headB, int tag) {
        if (tag % 2 == 1) {
            return headB;
        } else {
            return headA;
        }
    }

}
