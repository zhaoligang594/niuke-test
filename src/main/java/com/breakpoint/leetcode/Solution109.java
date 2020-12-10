package com.breakpoint.leetcode;

import com.breakpoint.utils.ListNode;
import com.breakpoint.utils.TreeNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/12
 */
public class Solution109 {

    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        while (null != head) {
            createTree(root, head);
            head = head.next;
        }
        return root;
    }

    public void createTree(TreeNode root, ListNode head) {
        if (root != null) {
            if (root.val < head.val) {
                if (root.right != null) {
                    createTree(root.right, head);
                } else {
                    root.right = new TreeNode(head.val);
                }
            } else {
                if (root.left != null) {
                    createTree(root.left, head);
                } else {
                    root.left = new TreeNode(head.val);
                }
            }
        }
    }
}
