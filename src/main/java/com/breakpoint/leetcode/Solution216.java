package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author breakpoint/赵先生
 * 2020/09/03
 */
public class Solution216 {

    /*
        找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

        说明：

        所有数字都是正整数。
        解集不能包含重复的组合。 
        示例 1:

        输入: k = 3, n = 7
        输出: [[1,2,4]]
        示例 2:

        输入: k = 3, n = 9
        输出: [[1,2,6], [1,3,5], [2,3,4]]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum-iii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution216().combinationSum3(3, 9);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0) {
            res.add(new ArrayList<>());
        }else {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            combinationSum3(nums, 0, k, n, new ArrayDeque<>());
        }
        return res;
    }

    public void combinationSum3(int[] nums, int start, int k, int n, Deque<Integer> deque) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (k - 1 >= 0 && n - nums[i] >= 0) {
                deque.addLast(nums[i]);
                System.out.println(deque);
                combinationSum3(nums, i + 1, k - 1, n - nums[i], deque);
                deque.pollLast();
            }
        }
    }

}
