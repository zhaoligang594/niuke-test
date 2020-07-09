package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
public class Solution617 {

    public static void main(String[] args) {

        // create tree
        Integer[] treeA = {1, 3, 2, 5};
        Integer[] treeB = {2, 1, 3, null, 4, null, 7};

        // create tree
        TreeNode rootA = TreeUtils.createTree(treeA);
        TreeNode rootB = TreeUtils.createTree(treeB);

        // combine trees
        TreeNode treeNode = new Solution617().mergeTrees(rootA, rootB);

        // print result
        System.out.println(treeNode);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            // 合并他们
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }

}
