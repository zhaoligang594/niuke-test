package com.breakpoint.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class TreeUtils {


    /**
     * 创建我们的二叉树
     */
    public static TreeNode createTree(Integer[] treeNodes) {
        if (null == treeNodes || treeNodes.length == 0) return null;
        Deque<TreeNode> queue = new ArrayDeque<>(16);
        TreeNode returnTreeNode = new TreeNode(treeNodes[0]);
        queue.addLast(returnTreeNode);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.removeFirst();
            if (i < treeNodes.length && null != treeNodes[i]) {
                TreeNode left = new TreeNode(treeNodes[i]);
                pop.left = left;
                queue.push(left);
                //i++;
            }
            i++;
            if (i < treeNodes.length && null != treeNodes[i]) {
                TreeNode right = new TreeNode(treeNodes[i]);
                pop.right = right;
                queue.push(right);

            }
            i++;
        }
        return returnTreeNode;
    }
}
