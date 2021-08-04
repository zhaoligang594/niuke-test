package com.breakpoint.leetcode2;

import java.util.Arrays;

public class Solution45 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = new Solution45().jump(nums);
    }

    // 时间复杂度是
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[nums.length - 1] != Integer.MAX_VALUE) break;
            int k = nums[i - 1];
            for (int j = i; j < i + k && j < nums.length; j++) {
                dp[j] = Math.min(dp[i - 1] + 1, dp[j]);
            }
        }
        return dp[nums.length - 1];
    }

    public int jump(int[] nums) {
        int res = 0;
        int end = nums.length - 1;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (nums[i] + i >= end) {
                    end = i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
