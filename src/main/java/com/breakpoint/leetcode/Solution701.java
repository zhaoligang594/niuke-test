package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author breakpoint/赵先生
 * 2020/09/30
 */
public class Solution701 {

    public static void main(String[] args) {

        Integer[] tree = {40, 20, 60, 10, 30, 50, 70};
        TreeNode root = TreeUtils.createTree(tree);
        TreeNode treeNode = new Solution701().insertIntoBST(root, 25);
        System.out.println(1);

    }

    //[40,20,60,10,30,50,70]
    //25

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null != root) {
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
        } else {
            return new TreeNode(val);
        }
        return root;
    }
}
