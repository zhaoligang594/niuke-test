package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
public class Solution114 {

    public static void main(String[] args) {

    }

    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                TreeNode preNode = list.get(i - 1);
                preNode.left = null;
                preNode.right = null;
                TreeNode cur = list.get(i);
                cur.left = null;
                cur.right = null;
                preNode.right = cur;
            }
        }
    }

    private void dfs(TreeNode root) {
        if (null != root) {
            list.add(root);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
