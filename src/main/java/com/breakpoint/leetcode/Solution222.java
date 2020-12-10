package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author breakpoint/赵先生
 * 2020/10/04
 */
public class Solution222 {

    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3, 4, 5, 6};
        TreeNode tree1 = TreeUtils.createTree(tree);
        int i = new Solution222().countNodes(tree1);
        System.out.println(i);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        seekDeep(root, 1);
        return ((int) Math.pow(2, height + 1) - 1 - 2 * count - other);
    }

    int height = -1, count = 0, other = 0;

    private void seekDeep(TreeNode root, int deep) {
        System.out.println(1);
        if (null != root) {
            if (null != root.right) {
                seekDeep(root.right, deep + 1);
            } else {
                if (height == -1) height = deep;
            }
            if (null == root.left && null == root.right && deep == height) count++;
            if (null != root.left) {
                if (deep < height) {
                    seekDeep(root.left, deep + 1);
                } else {
                    if (null == root.right) other++;
                }
            }
        }
    }


}
