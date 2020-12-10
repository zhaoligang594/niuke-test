package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author breakpoint/赵先生
 * 2020/09/04
 */
@Success
public class Solution257 {
    /*
        给定一个二叉树，返回所有从根节点到叶子节点的路径。

        说明: 叶子节点是指没有子节点的节点。

        示例:

        输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]

        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
        通过次数54,034提交次数82,923

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/binary-tree-paths
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        //Integer[] tree = {1, 2, 3, null, 5};
        //Integer[] tree = {1};
        Integer[] tree = {37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8};
        TreeNode root = TreeUtils.createTree(tree);
        List<String> list = new Solution257().binaryTreePaths(root);
        System.out.println(list);
    }


    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null && root.right == null && root.left == null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            res.add(sb.toString().substring(2));
            sb.delete(len, sb.length());
            return;
        }
        if (root != null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            if (root.left != null) dfs(root.left, sb);
            if (root.right != null) dfs(root.right, sb);
            sb.delete(len, sb.length());
        }
    }

}
