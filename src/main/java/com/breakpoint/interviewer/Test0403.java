package com.breakpoint.interviewer;

import com.breakpoint.utils.ListNode;
import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/12/09
 */
public class Test0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (null != tree) {
            int deep = getDeep(tree);
            ListNode[] res = new ListNode[deep];
            dfs(tree, 0,res);
            return res;
        }
        return new ListNode[0];
    }

    private int getDeep(TreeNode tree) {
        if (tree == null) return 0;
        return Math.max(getDeep(tree.left), getDeep(tree.right)) + 1;
    }

    public void dfs(TreeNode tree, int deep, ListNode[] res) {
        if (tree != null) {
            ListNode node = new ListNode(tree.val);
            if (res[deep] == null) {
                res[deep]=node;
            } else {
                node.next = res[deep];
                res[deep] = node;
            }
            dfs(tree.right, deep + 1,res);
            dfs(tree.left, deep + 1,res);
        }
    }


}
