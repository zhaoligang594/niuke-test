package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 129. 求根到叶子节点数字之和
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution129 {

    /*
        给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

        例如，从根到叶子节点路径 1->2->3 代表数字 123。

        计算从根到叶子节点生成的所有数字之和。

        说明: 叶子节点是指没有子节点的节点。

        示例 1:

        输入: [1,2,3]
            1
           / \
          2   3
        输出: 25
        解释:
        从根到叶子节点路径 1->2 代表数字 12.
        从根到叶子节点路径 1->3 代表数字 13.
        因此，数字总和 = 12 + 13 = 25.
        示例 2:

        输入: [4,9,0,5,1]
            4
           / \
          9   0
         / \
        5   1
        输出: 1026
        解释:
        从根到叶子节点路径 4->9->5 代表数字 495.
        从根到叶子节点路径 4->9->1 代表数字 491.
        从根到叶子节点路径 4->0 代表数字 40.
        因此，数字总和 = 495 + 491 + 40 = 1026.
        通过次数38,076提交次数58,864

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3};
        TreeNode root = TreeUtils.createTree(tree);
        int i = new Solution129().sumNumbers(root);
        System.out.println(i);

    }

    /**
     * 深度优先搜索二叉树 以及计算当前的值
     */
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            dfs(root, 10, 0);
        }
        return res;
    }

    // 深度优先遍历
    public void dfs(TreeNode root, int unit, int curNum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res += curNum * unit + root.val;
            }
            if (root.left != null) dfs(root.left, unit, curNum * unit + root.val);
            if (root.right != null) dfs(root.right, unit, curNum * unit + root.val);
        }
    }

}
