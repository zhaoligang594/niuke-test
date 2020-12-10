package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/09/06
 */
@Success
public class Solution107 {

    public static void main(String[] args) {
        Integer[] tree = {1, 2, 3, 4, null, null, 5};
        TreeNode tree1 = TreeUtils.createTree(tree);
        List<List<Integer>> lists = new Solution107().levelOrderBottom(tree1);
        System.out.println(lists);
    }

    Deque<List<Integer>> stack = new ArrayDeque<>();
    List<Integer> unit = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (null != root) {
            Deque<TreeNode> master = new ArrayDeque<>();
            master.addLast(root);
            levelTraverse(master, new ArrayDeque<>());
        }

        while (!stack.isEmpty()) {
            res.add(stack.pollLast());
        }
        return res;
    }

    public void levelTraverse(Deque<TreeNode> master, Deque<TreeNode> slave) {
        while (!master.isEmpty() || !slave.isEmpty()) {
            while (!master.isEmpty()) {
                TreeNode treeNode = master.pollFirst();
                unit.add(treeNode.val);
                if (treeNode.left != null) slave.addLast(treeNode.left);
                if (treeNode.right != null) slave.addLast(treeNode.right);
            }
            // 交换2个
            swich(master, slave);
            stack.addLast(unit);
            unit = new ArrayList<>();
        }
    }

    private void swich(Deque<TreeNode> queue1, Deque<TreeNode> queue2) {
        queue1.addAll(queue2);
        queue2.clear();
    }


}
