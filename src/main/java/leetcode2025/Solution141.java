package leetcode2025;

import com.breakpoint.utils.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/02
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
