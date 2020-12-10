package com.breakpoint.offer;

import com.breakpoint.annotation.Fail;
import com.breakpoint.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
@Fail
public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            res.add(treeNode.val);
            if (count % 2 == 0) {
                if (root.left != null) deque.addLast(treeNode.left);
                if (root.right != null) deque.addLast(treeNode.right);
            } else {
                if (root.right != null) deque.addLast(treeNode.right);
                if (root.left != null) deque.addLast(treeNode.left);
            }
        }
        return null;
    }
}
