package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/06
 */
public class Solution144 {

    public static void main(String[] args) {

    }
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode/
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if (null != root) {
            res.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
