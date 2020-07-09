package com.breakpoint.other;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/04
 */
public class Main02 {

    public static void main(String[] args) {

        Integer[] treeNode = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tree = TreeUtils.createTree(treeNode);
        //preTraversal(tree);
        levelTraversal(tree);
    }

    // 遍历的操作
    public static void preTraversal(TreeNode root) {
        if (null != root) {
            preTraversal(root.left);
            printTreeNode(root);
            preTraversal(root.right);
        }
    }

    // 水平
    public static void levelTraversal(TreeNode root) {
        if (null != root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.addFirst(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollLast();
                printTreeNode(treeNode);
                if (treeNode.left != null) queue.addFirst(treeNode.left);
                if (treeNode.right != null) queue.addFirst(treeNode.right);
            }
        }
    }


    // 打印节点
    public static void printTreeNode(TreeNode treeNode) {
        System.out.print(treeNode.val + " ");
    }


}
