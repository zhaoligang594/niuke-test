package com.breakpoint.offer;

import com.breakpoint.annotation.Fail;
import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-11
 */
@Fail
public class Offer32 {

    // 打印 二叉树
    public int[] levelOrder(TreeNode root) {
        if (null != root) {
            dfs(root);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void dfs(TreeNode root) {
        if (null != root) {
            res.add(root.val);
            if (null != root.left) dfs(root.left);
            if (null != root.right) dfs(root.right);
        }
    }
    List<Integer> res = new ArrayList<>();

}
