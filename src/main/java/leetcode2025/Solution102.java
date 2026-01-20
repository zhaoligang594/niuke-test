package leetcode2025;

import com.breakpoint.utils.TreeNode;
import com.breakpoint.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/13
 */
public class Solution102 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = new Solution102().levelOrder(tree);
    }

    TreeNode blank = new TreeNode(-10000000);
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root != null) {
            stack.addLast(root);
            stack.addLast(blank);
            List<Integer> tempList = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollFirst();
                if (node == blank) {
                    res.add(tempList);
                    tempList = new ArrayList<>();
                    if (stack.isEmpty()) {
                        break;
                    }
                    stack.addLast(blank);
                } else {
                    tempList.add(node.val);
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
            }
        }
        return res;
    }
}
