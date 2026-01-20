package leetcode2025;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution530 {

    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                res = Math.min(res, root.val - pre);
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
