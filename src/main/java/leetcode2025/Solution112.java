package leetcode2025;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null != root && null == root.left && null == root.right && root.val == targetSum) return true;
        if (null == root) return false;
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
