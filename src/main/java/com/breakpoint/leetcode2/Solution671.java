package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution671 {

    public static void main(String[] args) {
        Integer[] tree = {5, 5, 6};
        TreeNode root = TreeUtils.createTree(tree);
        new Solution671().findSecondMinimumValue(root);
    }

    List<Integer> list = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (list.size() >= 2) {
            Collections.sort(list);
            int one = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (one != list.get(i)) return list.get(i);
            }
        }
        return -1;
    }

    private void dfs(TreeNode root) {
        if (null != root) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
