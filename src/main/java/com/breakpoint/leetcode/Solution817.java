package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/13
 */
public class Solution817 {

    public static void main(String[] args) {
        int[] list = {0, 1, 2, 3, 4};
        int[] G = {0, 3, 1, 4};
        ListNode head = LinkListUtils.getListNodeByArray(list);
        int i = new Solution817().numComponents(head, G);
        System.out.println(i);
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (Integer val : G) {
            set.add(val);
        }
        int res = 0, tag = -1;
        while (head != null) {
            if (set.contains(head.val)) {
                tag = 0;
                head = head.next;
            } else {
                if (tag == 0) {
                    res++;
                    tag = -1;
                } else {
                    head = head.next;
                }
            }
        }
        if (tag == 0) {
            res++;
        }
        return res;
    }
}
