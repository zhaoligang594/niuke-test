package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author breakpoint/赵先生
 * 2020/10/03
 */
public class Solution872 {

    public static void main(String[] args) {
        Integer[] tree1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] tree2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
        TreeNode root1 = TreeUtils.createTree(tree1);
        TreeNode root2 = TreeUtils.createTree(tree2);
        boolean b = new Solution872().leafSimilar(root1, root2);
        System.out.println(b);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        stringByTree(root1, sb1);
        stringByTree(root2, sb2);
//        System.out.println(sb1.toString());
//        System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }

    private void stringByTree(TreeNode root, StringBuilder sb) {
        if (root != null) {
            if (root.left != null) {
                stringByTree(root.left, sb);
            }
            if (root.right != null) {
                stringByTree(root.right, sb);
            }
            if (null == root.right && root.left == null) {
                sb.append(root.val).append("$");
            }
        }
    }
}
