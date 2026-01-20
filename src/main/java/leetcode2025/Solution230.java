package leetcode2025;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution230 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.createTree(new Integer[]{2,1});
        int i = new Solution230().kthSmallest(tree, 1);
        System.out.println(i);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int nodeCnt = getNodeCnt(root.left);
        if (nodeCnt == k - 1) return root.val;
        if (nodeCnt >= k) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - nodeCnt - 1);
    }

    private int getNodeCnt(TreeNode node) {
        if (null == node) return 0;
        return 1 + getNodeCnt(node.left) + getNodeCnt(node.right);
    }
}
