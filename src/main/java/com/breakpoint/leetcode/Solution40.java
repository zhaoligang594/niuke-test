package com.breakpoint.leetcode;

import java.util.*;

/**
 * 40. 组合总和 II
 *
 * @author breakpoint/赵先生
 * 2020/09/03
 */
public class Solution40 {

    /*
        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的每个数字在每个组合中只能使用一次。

        说明：

        所有数字（包括目标数）都是正整数。
        解集不能包含重复的组合。 
        示例 1:

        输入: candidates = [10,1,2,7,6,1,5], target = 8,
        所求解集为:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
        示例 2:

        输入: candidates = [2,5,2,1,2], target = 5,
        所求解集为:
        [
          [1,2,2],
          [5]
        ]
        通过次数79,877提交次数127,653

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = new Solution40().combinationSum2(candidates, 5);
        System.out.println(lists);

    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    public void combinationSum2(int[] candidates, int target, int start, Deque<Integer> deque) {
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            if (target - candidates[i] > 0) {
                deque.addLast(candidates[i]);
                //System.out.println(deque);
                combinationSum2(candidates, target - candidates[i], i + 1, deque);
                deque.pollLast();
            } else if (target - candidates[i] == 0) {
                deque.addLast(candidates[i]);
                res.add(new ArrayList<>(deque));
                deque.pollLast();
            }
        }
    }
}
