package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;

/**
 * 100. 相同的树
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
public class Solution100 {

    /*
        给定两个二叉树，编写一个函数来检验它们是否相同。

        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

        示例 1:

        输入:       1         1
                  / \       / \
                 2   3     2   3

                [1,2,3],   [1,2,3]

        输出: true
        示例 2:

        输入:      1          1
                  /           \
                 2             2

                [1,2],     [1,null,2]

        输出: false
        示例 3:

        输入:       1         1
                  / \       / \
                 2   1     1   2

                [1,2,1],   [1,1,2]

        输出: false

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/same-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果是叶子节点 那么 是返回正确的
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            // 两个节点的值相同
            if (p.val == q.val) {
                // 深度递归判断是否相同
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                // 节点值不同 返回false
                return false;
            }
        }
        // 其他的情况 返回 false
        return false;
    }
}
