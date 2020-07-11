package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 124. 二叉树中的最大路径和
 * hard
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class Solution124 {
    /*
        给定一个非空二叉树，返回其最大路径和。

        本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

        示例 1:

        输入: [1,2,3]

               1
              / \
             2   3

        输出: 6
        示例 2:

        输入: [-10,9,20,null,null,15,7]

           -10
           / \
          9  20
            /  \
           15   7

        输出: 42
        通过次数59,655提交次数139,668

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        Integer[] tree = {2, -1};
        TreeNode root = TreeUtils.createTree(tree);
        int i = new Solution124().maxPathSum(root);
        System.out.println(i);
    }


    volatile int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return max;
    }
    private int maxPathSum2(TreeNode root) {
        if (null != root) {
            int val = root.val;
            int left = maxPathSum2(root.left);
            int right = maxPathSum2(root.right);

            if (left < 0) {
                left=0;
            }
            if (right < 0) {
                right=0;
            }
            if (val + left + right > max) {
                max = val + left + right;
            }
            return (left > right) ? left + val : right + val;
        } else {
            return 0;
        }
    }


}
