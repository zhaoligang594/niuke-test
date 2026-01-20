package leetcode2025;

import java.util.*;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/12
 */
public class Solution491 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(0, nums, stack);
        return res;
    }

    private void dfs(int start, int[] nums, Deque<Integer> stack) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (!stack.isEmpty() && stack.peekLast() > nums[i]) continue;
            stack.addLast(nums[i]);
            if (stack.size() > 1) {
                res.add(new ArrayList<>(stack));
            }
            dfs(i + 1, nums, stack);
            stack.pollLast();
        }
    }
}
