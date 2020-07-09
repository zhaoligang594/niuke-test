package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution101 {

    /*

     */
    public static void main(String[] args) {

        Integer[] nums = {1,2,2,3,4,4,3};
        TreeNode tree = TreeUtils.createTree(nums);
        boolean symmetric = new Solution101().isSymmetric(tree);
        System.out.println(symmetric);
    }


    // 判断是否是对称的
    /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return testTree(root.left,root.right);
    }

    public boolean testTree(TreeNode left, TreeNode right) {
        if (null != left && null != right) {
            if (left.val != right.val) {
                return false;
            }
            return testTree(left.left, right.right) && testTree(left.right, right.left);
        } else if (null == left && null == right) {
            return true;
        }
        return false;
    }
}
