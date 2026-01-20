package leetcode2025;

import com.breakpoint.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/05
 */
public class Solution437 {

    // 根节点到
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 当前 节点满足 == targetSum 的数量
        int ret = 0;
        curr += root.val;

        // 何为 curr
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
