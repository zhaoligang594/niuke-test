package com.breakpoint.leetcode;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution199 {

    /*

        输入: [1,2,3,null,5,null,4]
        输出: [1, 3, 4]
        解释:

           1            <---
         /   \
        2     3         <---
         \     \
          5     4       <---

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5, null};
        TreeNode tree = TreeUtils.createTree(nums);
        List<Integer> list = new Solution199().rightSideView(tree);
        System.out.println(list);
    }

    /*
            深度优先遍历的操作




     */

    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list, int level) {
        if (null != root) {
            if (level >= list.size()) {
                list.add(root.val);
            }
            dfs(root.right, list, level + 1);
            dfs(root.left, list, level + 1);
        }
    }


}
