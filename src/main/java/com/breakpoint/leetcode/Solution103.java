package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/01
 */
public class Solution103 {


    public static void main(String[] args) {

        Integer[] arr = {3, 9, 20, null, null, 15, 7};

        TreeNode tree = TreeUtils.createTree(arr);

        List<List<Integer>> lists = new Solution103().zigzagLevelOrder(tree);

        System.out.println(lists);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        Stack<TreeNode>[] opts = new Stack[2];
        opts[0] = new Stack<>();
        opts[1] = new Stack<>();
        opts[0].push(root);
        int i = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        while (!opts[i].isEmpty()) {
            TreeNode pop = opts[i].pop();
            if (null != pop) {
                item.add(pop.val);
                int index = (i + 1) % 2;

                if (1 == index) {
                    opts[index].push(pop.left);
                    opts[index].push(pop.right);
                } else {
                    opts[index].push(pop.right);
                    opts[index].push(pop.left);
                }
            }
            if (opts[i].isEmpty()) {
                i = (i + 1) % 2;
                if (!item.isEmpty()) {
                    lists.add(item);
                    item = new ArrayList<>();
                }
            }
        }
        return lists;
    }
}
