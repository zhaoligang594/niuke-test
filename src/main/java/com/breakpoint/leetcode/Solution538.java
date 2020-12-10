package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author breakpoint/赵先生
 * 2020/09/30
 */
public class Solution538 {

    public static void main(String[] args) {
        Integer[] tree = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = TreeUtils.createTree(tree);
        TreeNode treeNode = new Solution538().convertBST(root);
        System.out.println(1);
    }

    /**
     * 将这个转变为题目要求的 那么我们需要一个带有返回的方法
     * 下面采用的是深度遍历的方式 实现返回相应的值的操作
     */
    public TreeNode convertBST(TreeNode root) {
        if (null == root) return root;
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int val) {
        // 判断当前的跟节点是否是空的
        if (root != null) {
            // 本层树 返回给上层节点的值
            int res = 0;
            // 右 子树 不是空 那么就 就深入到最下层 求解返回 带上原来的参数
            if (root.right != null) {
                root.val += dfs(root.right, val);
            } else {
                // 最下面的节点
                root.val += val;
            }
            // 左子树不为空的时候 深度递归
            if (root.left != null) {
                int kk = dfs(root.left, root.val);
                res = kk;
            } else {
                // 如果是空的情况，那么就返回最下面的值
                res = root.val;
            }
            return res;
        } else {
            return 0;
        }
    }
}
