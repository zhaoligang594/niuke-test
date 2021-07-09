package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/submissions/
 */
@Success
public class Solution337 {

    public static void main(String[] args) {

    }

    // 带有备忘录的动态规划的操作
    Map<TreeNode, Integer> selectMap = new HashMap<>();
    Map<TreeNode, Integer> unSelectMap = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Integer unSelectMax = unSelectMap.get(root);
        if (null == unSelectMax) {
            int maxLeft = rob(root.left);
            int maxRight = rob(root.right);
            unSelectMax = maxLeft + maxRight;
            unSelectMap.put(root, unSelectMax);
        }
        Integer selectMax = selectMap.get(root);
        if (null == selectMax) {
            int temp = root.val;
            temp += root.left != null ? rob(root.left.left) + rob(root.left.right) : 0;
            temp += root.right != null ? rob(root.right.left) + rob(root.right.right) : 0;
            selectMax = temp;
            selectMap.put(root, temp);
        }
        return Math.max(selectMax, unSelectMax);
    }


}
