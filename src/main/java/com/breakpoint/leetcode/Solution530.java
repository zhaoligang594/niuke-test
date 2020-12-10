package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author breakpoint/赵先生
 * 2020/10/12
 */
public class Solution530 {

    public static void main(String[] args) {

        Integer[] tree = {1, null, 3, 2};
        TreeNode root = TreeUtils.createTree(tree);
        int minimumDifference = new Solution530().getMinimumDifference(root);
        System.out.println(minimumDifference);

    }

    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                res = Math.min(res, root.val - pre);
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
