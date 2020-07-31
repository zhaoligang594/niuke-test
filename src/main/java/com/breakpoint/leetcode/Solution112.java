package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/submissions/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution112 {
    /*
        给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

        说明: 叶子节点是指没有子节点的节点。

        示例: 
        给定如下二叉树，以及目标和 sum = 22，

                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \      \
                7    2      1
        返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

        通过次数113,632提交次数223,578

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/path-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Integer[] treeNums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode tree = TreeUtils.createTree(treeNums);
        boolean b = new Solution112().hasPathSum(tree, 22);
        System.out.println(b);
    }

    /**
     * 二叉树的遍历的操作
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean returnVal = false;
        if (null != root) {
            if (root.right == null && root.left == null && root.val == sum) {
                return true;
            }
            returnVal = hasPathSum(root.left, sum - root.val);
            returnVal = !returnVal ? hasPathSum(root.right, sum - root.val) : returnVal;
        }
        return returnVal;
    }
}
