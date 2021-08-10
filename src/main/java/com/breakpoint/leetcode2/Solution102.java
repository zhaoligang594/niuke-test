package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/08
 */
public class Solution102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, int depth, TreeNode root) {
        if (null == root) return;
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        List<Integer> temp = res.get(depth);
        temp.add(root.val);
        dfs(res, depth + 1, root.left);
        dfs(res, depth + 1, root.right);
    }
}
