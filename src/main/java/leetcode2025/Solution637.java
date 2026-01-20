package leetcode2025;

import com.breakpoint.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution637 {

    double[] levelTotal = new double[10001];
    int[] levelCount = new int[10001];
    int maxLevel = 0;

    public List<Double> averageOfLevels(TreeNode root) {
        averageOfLevels(root, 0);
        List<Double> res = new ArrayList<Double>();
        for (int i = 0; i < maxLevel; i++) {
            res.add(levelTotal[i] / levelCount[i]);
        }
        return res;
    }

    private void averageOfLevels(TreeNode root, int level) {
        if (root == null) return;
        levelTotal[level] += root.val;
        levelCount[level]++;
        maxLevel = Math.max(maxLevel, level + 1);
        averageOfLevels(root.left, level + 1);
        averageOfLevels(root.right, level + 1);
    }
}
