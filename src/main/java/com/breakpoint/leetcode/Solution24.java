package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

import java.util.Stack;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class Solution24 {
    /*
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

        示例:

        给定 1->2->3->4, 你应该返回 2->1->4->3.
        通过次数122,691提交次数185,575

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNodeByArray = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution24().swapPairs(listNodeByArray);
        System.out.println(listNode);
    }

    // 官方递归
    // 官方递归的方式求解问题
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    // 自己写的方法
//    public ListNode swapPairs(ListNode head) {
//
//        if (null == head || null == head.next) {
//            return head;
//        }
//
//        ListNode res = null, cur = null;
//
//        Stack<ListNode> stack = new Stack<>();
//
//
//        while (null != head) {
//            ListNode temp = head;
//            while (null != temp) {
//                stack.push(temp);
//                temp = temp.next;
//                if (stack.size() == 2) {
//                    head = temp;
//                    break;
//                }
//            }
//
//            if (stack.size() < 2) {
//                cur.next = head;
//                cur = stack.peek();
//                stack.clear();
//                head = null;
//            }
//
//            while (!stack.isEmpty()) {
//                if (null == res) {
//                    res = stack.pop();
//                    cur = res;
//                } else {
//                    cur.next = stack.pop();
//                    cur = cur.next;
//                }
//            }
//        }
//
//        if (cur != null) {
//            cur.next = null;
//        }
//
//        return res;
//
//    }
}
