package leetcode2025;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution98 {

    public static void main(String[] args) {
        boolean validBST = new Solution98().isValidBST(TreeUtils.createTree(new Integer[]{-1, -1}));
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    boolean res = true;
    Integer pre = null;

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (pre == null) {
                pre = root.val;
            } else {
                if (pre >= root.val) {
                    res = false;
                }
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
