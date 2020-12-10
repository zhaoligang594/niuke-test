package com.breakpoint.leetcode;

import com.breakpoint.utils.LinkListUtils;
import com.breakpoint.utils.ListNode;
import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 查找二叉树 里面有没有
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution1367 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 6};
        ListNode head = LinkListUtils.getListNodeByArray(nums);
        Integer[] tree = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};
        TreeNode root = TreeUtils.createTree(tree);
        boolean subPath = new Solution1367().isSubPath(head, root);
        System.out.println(subPath);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head != null && root != null && head.val == root.val) {
            if (dfs(head, root)) return true;
        }
        if (root.left != null) {
            if (isSubPath(head, root.left)) return true;
        }
        if (root.right != null) {
            if (isSubPath(head, root.right)) return true;
        }
        return false;
    }

    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root != null && head.val != root.val) return false;
        if (head.next == null) return true;
        if (root != null && root.left != null) {
            if (dfs(head.next, root.left)) return true;
        }
        if (root != null && root.right != null) {
            if (dfs(head.next, root.right)) return true;
        }
        return false;
    }
}
