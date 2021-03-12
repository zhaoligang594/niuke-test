package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/10/22
 */
public class Solution673 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int numberOfLIS = new Solution673().findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, max = 0;
        if (nums.length > 0) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                if (maxLen < dp[i]) {
                    maxLen = dp[i];
                    max = 1;
                } else if (maxLen == dp[i]) {
                    max++;
                }
            }
        }
        return max;
    }
}
