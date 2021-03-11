package com.breakpoint.offer;

import com.breakpoint.utils.ListNode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-26
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        reversePrint(head, 0);
        return res;
    }

    int[] res = null;

    public void reversePrint(ListNode head, int index) {
        if (head != null) {
            reversePrint(head.next, index + 1);
            res[index] = head.val;
        } else {
            if (res == null) res = new int[index];
        }
    }
}
