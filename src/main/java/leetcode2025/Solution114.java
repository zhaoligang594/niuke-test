package leetcode2025;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            flatten(left);
        }
        if (right != null) {
            flatten(right);
        }
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
                left.left = null;
            }
            left.right = right;
        } else {
            root.right = right;
        }
    }
}
