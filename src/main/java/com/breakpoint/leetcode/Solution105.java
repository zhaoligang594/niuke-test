package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;

/**
 * @author breakpoint/赵先生
 * 2020/10/31
 */
public class Solution105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution105().buildTree(preorder, inorder);
        System.out.println(true);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int[][][] left = getLeft(preorder, inorder, preorder[0]);
        node.left = buildTree(left[0][0], left[0][1]);
        node.right = buildTree(left[1][0], left[1][1]);
        return node;
    }


    private int[][][] getLeft(int[] preorder, int[] inorder, int tag) {
        int[][][] res = new int[2][2][];
        int i = 0;
        for (; i < inorder.length; i++) {
            if (tag == inorder[i]) break;

        }
        int[] preL = new int[i];
        for (int k = 0; k < i; k++) {
            preL[k] = preorder[k + 1];
        }
        int[] inL = new int[i];
        for (int k = 0; k < i; k++) {
            inL[k] = inorder[k];
        }

        int[] preR = new int[preorder.length - i - 1];
        for (int k = 0; k < preR.length; k++) {
            preR[k] = preorder[i + 1 + k];
        }
        int[] inR = new int[preorder.length - i - 1];
        for (int k = 0; k < inR.length; k++) {
            inR[k] = inorder[i + 1 + k];
        }
        res[0][0] = preL;
        res[0][1] = inL;
        res[1][0] = preR;
        res[1][1] = inR;
        return res;
    }


}
