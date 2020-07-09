package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * https://leetcode-cn.com/problems/path-sum/submissions/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution112 {

    public static void main(String[] args) {
        Integer[] treeNums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode tree = TreeUtils.createTree(treeNums);
        boolean b = new Solution112().hasPathSum(tree, 22);
        System.out.println(b);
    }

    /**
     * 二叉树的遍历的操作
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean returnVal = false;
        if (null != root) {
            if (root.right == null && root.left == null && root.val == sum) {
                return true;
            }
            returnVal = hasPathSum(root.left, sum - root.val);
            returnVal = !returnVal ? hasPathSum(root.right, sum - root.val) : returnVal;
        }
        return returnVal;
    }
}
