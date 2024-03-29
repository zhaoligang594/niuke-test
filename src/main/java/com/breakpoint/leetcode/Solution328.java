package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 328. 奇偶链表
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution328 {
    /*
        给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

        请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

        示例 1:

        输入: 1->2->3->4->5->NULL
        输出: 1->3->5->2->4->NULL
        示例 2:

        输入: 2->1->3->5->6->4->7->NULL
        输出: 2->3->6->7->1->5->4->NULL
        说明:

        应当保持奇数节点和偶数节点的相对顺序。
        链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/odd-even-linked-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = LinkListUtils.getListNodeByArray(nums);
        ListNode listNode = new Solution328().oddEvenList(head);
        System.out.println(listNode);
    }

    // 解决奇偶的链表
    public ListNode oddEvenList(ListNode head) {
        if (null == head || head.next == null || head.next.next == null) return head;
        ListNode cur = head, pre = head;
        // 循环的修改
        while (cur.next != null && cur.next.next != null) {
            // 偶位置
            ListNode even = cur.next;
            // 奇位置
            ListNode odd = cur.next.next;
            // 修改索引
            even.next = odd.next;
            odd.next = pre.next;
            pre.next = odd;
            cur = even;
            // 向下移位
            pre = pre.next;
        }
        return head;
    }
}
