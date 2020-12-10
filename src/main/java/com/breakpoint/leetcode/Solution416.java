package com.breakpoint.leetcode;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 *
 * @author breakpoint/赵先生
 * 2020/10/11
 */
public class Solution416 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean b = new Solution416().canPartition(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int len = nums.length, target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;

        if (nums[0] == target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }


//    private boolean seek(int[] nums, int target, int start) {
//        if (target == 0) return true;
//        if (target < 0) return false;
//        boolean res = false;
//        for (int i = start; i < nums.length; i++) {
//            if (target - nums[i] < 0) continue;
//            if (i > start && nums[i] == nums[i - 1]) continue;
//            res |= seek(nums, target - nums[i], i + 1);
//        }
//        return res;
//    }
}
