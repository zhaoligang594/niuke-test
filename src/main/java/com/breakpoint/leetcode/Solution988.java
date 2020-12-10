package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 *
 * @author breakpoint/赵先生
 * 2020/10/29
 */
public class Solution988 {

    public static void main(String[] args) {
        Integer[] tree = {25, 1, 3, 1, 3, 0, 2};
        TreeNode root = TreeUtils.createTree(tree);
        String s = new Solution988().smallestFromLeaf(root);
        System.out.println(s);
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root != null) {
            dfs(root, new StringBuilder());
        }
        return res;
    }

    String res = null;

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                int len = sb.length();
                sb.append((char) (root.val + 'a'));
                sb.reverse();
                if (res == null) {
                    res = sb.toString();
                } else {
                    if ((res + sb.toString()).compareTo(sb.toString() + res) > 0) {
                        res = sb.toString();
                    }
                }
                sb.reverse();
                sb.delete(len, sb.length());
                return;
            }
            int len = sb.length();
            sb.append((char) (root.val + 'a'));
            if (root.left != null) dfs(root.left, sb);
            if (root.right != null) dfs(root.right, sb);
            sb.delete(len, sb.length());
        }
    }
}
