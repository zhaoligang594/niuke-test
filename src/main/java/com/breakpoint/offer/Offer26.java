package com.breakpoint.offer;

import com.breakpoint.utils.TreeNode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-10
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        String treeStringA = getTreeString(A);
        String treeStringB = getTreeString(B);
        System.out.println(treeStringA);
        System.out.println(treeStringB);
        return treeStringA.contains(treeStringB);
    }


    private String getTreeString(TreeNode root) {
        if (null == root) return "#";
        return root.val + "#" + getTreeString(root.left) + "#" + getTreeString(root.right);
    }
}
