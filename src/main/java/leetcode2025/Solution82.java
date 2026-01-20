package leetcode2025;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/04
 */
public class Solution82 {

    public static void main(String[] args) {
        ListNode listNode = new Solution82().deleteDuplicates(LinkListUtils.getListNodeByArray(new int[]{1, 2, 3, 3, 4, 4, 5}));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        while (cur.next != null) {
            while (null != cur.next.next && pre.next.val == cur.next.next.val) {
                cur = cur.next;
            }
            if (pre != cur) {
                pre.next = cur.next.next;
                cur = pre;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
