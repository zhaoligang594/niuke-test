package com.breakpoint.offer;

import com.breakpoint.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/26
 */
public class Offer07 {

    /*
        输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

        例如，给出

        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：

            3
           / \
          9  20
            /  \
           15   7
         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Offer07().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    // 采用递归的方式进行求解
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int index = getIndex(inorder, preorder[p_start], i_start, i_end);
        root.left = buildTree(preorder, p_start + 1, p_start + index,
                inorder, i_start, i_start + index - 1);
        root.right = buildTree(preorder, p_start + index + 1, p_end,
                inorder, i_start + index + 1, i_end);
        return root;
    }

    Map<Integer, Integer> map = new HashMap<>();

    // 根据范围来进行获取
    private int getIndex(int[] array, int target, int start, int end) {
//        for (int i = start; i <= end; i++) {
//            if (array[i] == target) return i - start;
//        }
//        return -1;
        return map.get(target) - start;
    }

    private int[] getArrayByRange(int[] array, int start, int end) {
        if (start >= array.length) {
            return new int[0];
        }
        int[] res = new int[end - start + 1];
        for (int i = start; i <= end && i < array.length; i++) {
            res[i - start] = array[i];
        }
        return res;
    }


//    // 采用递归的方式进行求解
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (null == preorder || preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        int index = getIndex(inorder, preorder[0]);
//        root.left = buildTree(getArrayByRange(preorder, 1, 1 + index - 1),
//                getArrayByRange(inorder, 0, index - 1));
//        root.right = buildTree(getArrayByRange(preorder, 1 + index, preorder.length - 1),
//                getArrayByRange(inorder, 1 + index, inorder.length - 1));
//        return root;
//    }

    private int getIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

}
