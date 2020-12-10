package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * middle
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/24
 */
public class Solution148 {

    /*
        在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

        示例 1:

        输入: 4->2->1->3
        输出: 1->2->3->4
        示例 2:

        输入: -1->5->3->4->0
        输出: -1->0->3->4->5
        通过次数85,201提交次数127,577

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sort-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};
        ListNode head = LinkListUtils.getListNodeByArray(array);
        ListNode listNode = new Solution148().sortList(head);
        System.out.println(listNode);
    }


    public ListNode sortList(ListNode head) {


        return head;
    }


}
