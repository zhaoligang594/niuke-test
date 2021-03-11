package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-09
 */
@Success
public class Solution1026 {

    public static void main(String[] args) {
        Integer[] tree = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        TreeNode root = TreeUtils.createTree(tree);
        int i = new Solution1026().maxAncestorDiff(root);
        System.out.println(i);
    }


    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return res;
    }

    int res = 0;
    Deque<Integer> minStack = new ArrayDeque<>();
    Deque<Integer> maxStack = new ArrayDeque<>();

    private void add(Integer val) {
        if (minStack.isEmpty() || minStack.peekLast() > val) {
            minStack.addLast(val);
        } else {
            minStack.addLast(minStack.peekLast());
        }
        if (maxStack.isEmpty() || maxStack.peekLast() < val) {
            maxStack.addLast(val);
        } else {
            maxStack.addLast(maxStack.peekLast());
        }
    }

    private void remove(Integer val) {
        if (!minStack.isEmpty()) {
            minStack.pollLast();
        }
        if (!maxStack.isEmpty()) {
            maxStack.pollLast();
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            res = Math.max(res, maxStack.peekLast() - minStack.peekLast());
        } else {
            add(root.val);
            dfs(root.left);
            dfs(root.right);
            remove(root.val);
        }
    }

}
