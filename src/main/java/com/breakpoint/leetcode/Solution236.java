package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.Stack;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class Solution236 {

    /*
        示例 1:

        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出: 3
        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
        示例 2:

        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出: 5
        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
         

        说明:

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Integer[] tree = {9, -1, -4, 10, 3, null, null, null, 5};

        TreeNode root = TreeUtils.createTree(tree);
        TreeNode p = new TreeNode(3), q = new TreeNode(5);

        TreeNode treeNode = new Solution236().lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }


    /*
        [9,-1,-4,10,3,null,null,null,5]
            3
            5
     */


    TreeNode ans = null;

    // 官方的操作
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        // 都是真 或者 有一个是真的 才可以
        if ((left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;


        // 10
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode seek = seek(root, p, q, stack);
//        TreeNode candidate = null;
//        TreeNode tow = seek.val == p.val ? q : p;
//        candidate = stack.pop();
//        while (!stack.isEmpty()) {
//
//            if (null == seek(candidate, tow, null, null)) {
//                candidate = stack.pop();
//            } else {
//                break;
//            }
//        }
//
//        candidate.left = null;
//        candidate.right = null;
//        return candidate;
    }


    private TreeNode seek(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> stack) {
        Stack<TreeNode> opt = null != stack ? stack : new Stack<TreeNode>();
        TreeNode pre = root, res = null;
        label1:
        {
            while (!opt.isEmpty() || null != pre) {
                while (pre != null) {
                    opt.push(pre);
                    if ((p != null && pre.val == p.val) || (q != null && pre.val == q.val)) {
                        res = pre;
                        break label1;
                    }
                    pre = pre.left;
                }
                if (!opt.isEmpty()) {
                    pre = opt.pop().right;
                }
            }
        }
        return res;
    }


}
