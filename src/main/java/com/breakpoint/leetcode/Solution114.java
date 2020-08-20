package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * middle
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/02
 */
public class Solution114 {
    /*
        给定一个二叉树，原地将它展开为一个单链表。

 

        例如，给定二叉树

            1
           / \
          2   5
         / \   \
        3   4   6
        将其展开为：

        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        Integer[] tree = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeUtils.createTree(tree);
        new Solution114().flatten(root);
        System.out.println(1);

    }

    /**
     * 原地的展开
     *
     * @param root
     */
    public void flatten(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        // 主要的思想是 保存一下right 的数据
        while (null != temp || !stack.isEmpty()) {
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if (null != right) {
                stack.push(right);
            }
            if (null == left) {
                if(stack.isEmpty()){
                    break;
                }else {
                    left = stack.pop();
                }
            }
            temp.right = left;
            temp.left = null;
            temp = left;
        }
    }

}
