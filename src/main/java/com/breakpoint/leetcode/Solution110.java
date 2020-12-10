package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author breakpoint/赵先生
 * 2020/10/03
 */
public class Solution110 {

    public static void main(String[] args) {
        Integer[] tree = {1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeUtils.createTree(tree);
        boolean balanced = new Solution110().isBalanced(root);
        System.out.println(balanced);
    }

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        deepTree(root);
        return res;
    }
    private int deepTree(TreeNode root) {
        if (res) {
            if (null != root) {
                int left = 1 + deepTree(root.left);
                int right = 1 + deepTree(root.right);
                if (Math.abs(left - right) > 1) {
                    res = false;
                }
                return Math.max(left, right);
            } else {
                return 0;
            }
        }
        return -1;
    }
}
