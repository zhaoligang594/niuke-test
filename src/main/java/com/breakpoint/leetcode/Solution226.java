package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 *
 * @author breakpoint/赵先生
 * 2020/10/27
 */
@Success
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (null != root) {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
