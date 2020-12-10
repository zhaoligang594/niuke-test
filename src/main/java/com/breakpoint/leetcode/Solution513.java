package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 寻找二叉树的左下角的数值
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution513 {

    public static void main(String[] args) {
        Integer[] tree = {0};
        TreeNode root = TreeUtils.createTree(tree);
        int bottomLeftValue = new Solution513().findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    // 二叉树的深度遍历
    int res = -1;
    int level = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode root, int curLevel) {
        if (root != null) {
            if (curLevel > level) {
                res = root.val;
                level = curLevel;
            }
            if (root.left != null) dfs(root.left, curLevel + 1);
            if (root.right != null) dfs(root.right, curLevel + 1);
        }
    }
}
