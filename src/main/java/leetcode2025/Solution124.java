package leetcode2025;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/05
 */
public class Solution124 {


    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        max = Math.max(max, root.val + Math.max(left, 0) + Math.max(right, 0));
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
