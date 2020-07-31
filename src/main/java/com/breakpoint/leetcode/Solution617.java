package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

/**
 * 617. 合并二叉树
 * simple
 * <p>
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
public class Solution617 {
    /*
        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

        示例 1:

        输入:
            Tree 1                     Tree 2
                  1                         2
                 / \                       / \
                3   2                     1   3
               /                           \   \
              5                             4   7
        输出:
        合并后的树:
                 3
                / \
               4   5
              / \   \
             5   4   7
        注意: 合并必须从两个树的根节点开始。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/merge-two-binary-trees
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

        // create tree
        Integer[] treeA = {1, 3, 2, 5};
        Integer[] treeB = {2, 1, 3, null, 4, null, 7};

        // create tree
        TreeNode rootA = TreeUtils.createTree(treeA);
        TreeNode rootB = TreeUtils.createTree(treeB);

        // combine trees
        TreeNode treeNode = new Solution617().mergeTrees(rootA, rootB);

        // print result
        System.out.println(treeNode);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            // 合并他们
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }

}
