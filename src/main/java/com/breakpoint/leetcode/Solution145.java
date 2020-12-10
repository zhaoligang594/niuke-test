package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/19
 */
public class Solution145 {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null != root) {
            Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
            Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
            stack1.addLast(root);
            while (!stack1.isEmpty()) {
                root = stack1.pollLast();
                stack2.addLast(root);
                if (root.left != null) stack1.addLast(root.left);
                if (root.right != null) stack1.addLast(root.right);

            }
            while (!stack2.isEmpty()) {
                res.add(stack2.pollLast().val);
            }
        }
        return res;
    }
}
