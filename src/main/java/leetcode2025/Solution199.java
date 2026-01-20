package leetcode2025;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list, 0);
        return list;
    }

    // 每一个否是首次添加的内容
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
