package leetcode2025;

import com.breakpoint.utils.ListNode;


/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (n-- > 0) head = head.next;
        ListNode pre = dummy;
        while (null != head) {
            pre = pre.next;
            head = head.next;
        }
        if (null != pre.next) pre.next = pre.next.next;
        return dummy.next;
    }
}
