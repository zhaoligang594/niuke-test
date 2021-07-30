package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;

public class Solution230 {

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        boolean[] num = new boolean[10_001];
        dfs(root, num);
        for (int i = 0; i < num.length; i++) {
            if (num[i]) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, boolean[] num) {
        if (root != null) {
            num[root.val] = true;
            dfs(root.left, num);
            dfs(root.right, num);
        }
    }
}
