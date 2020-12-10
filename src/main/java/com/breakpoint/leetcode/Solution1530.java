package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
 *
 * @author breakpoint/赵先生
 * 2020/10/03
 */
public class Solution1530 {

    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3, null, 4};
        TreeNode root = TreeUtils.createTree(tree);
        int i = new Solution1530().countPairs(root, 3);
        System.out.println(i);

    }

    public int countPairs(TreeNode root, int distance) {
        return -1;
    }

    public void preOrder(TreeNode root, int distance) {
        if (null != root) {
            if (null != root.left) {
                preOrder(root.left, distance);
            }
            if (null != root.right) {
                preOrder(root.right, distance);
            }
            if (null == root.left && null == root.right) {
                //findNodes
            }
        }
    }

}
