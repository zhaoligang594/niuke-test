package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 树的深度
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution104 {

    /*
        二叉树深度求解
     */
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeUtils.createTree(nums);
        int i = new Solution104().maxDepth(tree);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
