package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author breakpoint/赵先生
 * 2020/11/25
 */
public class Solution814 {

    public static void main(String[] args) {
        Integer[] tree = {0,null,0,0,0};
        TreeNode root = TreeUtils.createTree(tree);
        TreeNode treeNode = new Solution814().pruneTree(root);
        System.out.println();
    }

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if(null!=root&&root.left==null&&root.right==null&&root.val==0) return null;
        return root;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return false;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;
    }
}
