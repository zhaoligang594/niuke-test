package com.breakpoint.diditest;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/12/08
 */
public class Testone {

//    select name from (
//            select name,sum(score) score from user_table group by name
//    )table1 order by score limit 0,10;


    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        System.out.println(bSearch(nums, 0));
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(list);

        ListNode node = reverseList(head);

        System.out.println(node);

    }


    public static int bSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode res = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
        }
        return res;
    }

}
