package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;
import com.breakpoint.utils.ListUtils;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
public class Solution19 {

    public static void main(String[] args) {
        ListNode head = LinkListUtils.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = new Solution19().removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=head,cur=head;
        if(head.next==null&&n==1) return null;
        while(n>=0&&cur!=null){
            cur=cur.next;
            n--;
        }
        while(cur!=null){
            cur=cur.next;
            pre=pre.next;
        }
        if(pre==head){
            //System.out.println(n);
            if(n==0) return pre.next;
            pre.next=pre.next.next;
            return pre;
        }else{
            pre.next=pre.next.next;
            return head;
        }
    }
}
