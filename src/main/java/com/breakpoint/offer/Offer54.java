package com.breakpoint.offer;

import com.breakpoint.annotation.Success;
import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-25
 */
@Success
public class Offer54 {

    public static void main(String[] args) {

    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthLargest(root,list);
        return list.get(k-1);
    }

    public void kthLargest(TreeNode root, List<Integer> list) {
        if (null != root) {
            if (root.right != null) kthLargest(root.right, list);
            list.add(root.val);
            if (root.left != null) kthLargest(root.left, list);
        }
    }

}
