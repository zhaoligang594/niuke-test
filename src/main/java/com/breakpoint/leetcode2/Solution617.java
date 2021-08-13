package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;

/**
 * 617. 合并二叉树
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/13
 */
public class Solution617 {

    // 递归的方式 合并二叉树的操作
    // 合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = null;
        if (root1 != null && root2 != null) {
            res = new TreeNode(root1.val + root2.val);
            res.left = mergeTrees(root1.left, root2.left);
            res.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            res = new TreeNode(root1.val);
            res.left = mergeTrees(root1.left, null);
            res.right = mergeTrees(root1.right, null);
        } else if (root2 != null) {
            res = new TreeNode(root2.val);
            res.left = mergeTrees(null, root2.left);
            res.right = mergeTrees(null, root2.right);
        }
        return res;
    }
}
