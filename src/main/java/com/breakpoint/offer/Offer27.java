package com.breakpoint.offer;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-11
 */
@Success
public class Offer27 {

    public static void main(String[] args) {

    }

    //
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }
}
