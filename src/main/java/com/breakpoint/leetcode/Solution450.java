//package com.breakpoint.leetcode;
//
//import com.breakpoint.utils.TreeNode;
//import com.breakpoint.utils.TreeUtils;
//
///**
// * @author breakpoint/赵先生
// * 2020/11/19
// */
//public class Solution450 {
//
//    public static void main(String[] args) {
//        Integer[] tree = {5, 3, 6, 2, 4, null, 7};
//        TreeNode root = TreeUtils.createTree(tree);
//        TreeNode treeNode = new Solution450().deleteNode(root, 5);
//        System.out.println(treeNode);
//
//    }
//
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (null == root) return root;
//        TreeNode cur = root, pre = null;
//        while (null != cur && cur.val != key) {
//            pre = cur;
//            if (cur.val > key) {
//                cur = cur.left;
//            }
//            else {
//                cur = cur.right;
//            }
//        }
//        if (null != cur) {
//            TreeNode next = cur.right;
//            if (next == null) pre.left = cur.left;
//
//
//        } else {
//            return root;
//        }
//    }
//}
