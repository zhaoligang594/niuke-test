package leetcode2025;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        if (null == root) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (null != root.left) {
            root.left.val += 10 * root.val;
        }
        if (null != root.right) {
            root.right.val += 10 * root.val;
        }
        int left = sumNumbers(root.left);
        int right = sumNumbers(root.right);
        return left + right;
    }
}
