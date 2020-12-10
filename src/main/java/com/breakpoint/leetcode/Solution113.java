package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/17
 */
public class Solution113 {

    public static void main(String[] args) {
        Integer[] tree = {-2, null, -3};
        TreeNode tree1 = TreeUtils.createTree(tree);
        List<List<Integer>> lists = new Solution113().pathSum(tree1, -5);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null != root) {
            dfs(root, sum, 0, new ArrayDeque<>());
        }
        return res;
    }

    public void dfs(TreeNode root, int sum, int cur, Deque<Integer> deque) {
        if (null != root) {
            if (root.left == null && root.right == null) {
                if (root.val + cur == sum) {
                    deque.addLast(root.val);
                    res.add(new ArrayList<>(deque));
                    deque.pollLast();
                }
                return;
            }
            deque.addLast(root.val);
            if (root.left != null) {
                dfs(root.left, sum, cur + root.val, deque);

            }
            if (root.right != null) {
                dfs(root.right, sum, cur + root.val, deque);
            }
            deque.pollLast();

        }
    }

}
