package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 437. 路径总和 III
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Solution437 {
    /*
        给定一个二叉树，它的每个结点都存放着一个整数值。

        找出路径和等于给定数值的路径总数。

        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

        示例：

        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

              10
             /  \
            5   -3
           / \    \
          3   2   11
         / \   \
        3  -2   1

        返回 3。和等于 8 的路径有:

        1.  5 -> 3
        2.  5 -> 2 -> 1
        3.  -3 -> 11
        通过次数50,740提交次数90,811

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/path-sum-iii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Integer[] tree = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = TreeUtils.createTree(tree);

        int i = new Solution437().pathSum(root, 8);
        System.out.println(i);

    }

    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        pathSum2(root, sum);
        return res;
    }
    public void pathSum2(TreeNode root, int sum) {
        dfs(root, sum);
        if (root.left != null) pathSum2(root.left, sum);
        if (root.right != null) pathSum2(root.right, sum);
    }
    public void dfs(TreeNode root, int sum) {
        if (root != null) {
            if (root.val == sum) {
                res++;
            }
            if (root.left != null) dfs(root.left, sum - root.val);
            if (root.right != null) dfs(root.right, sum - root.val);
        }
    }
}
