package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/03
 */
public class Solution213 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new Solution213().rob(nums);
        System.out.println(rob);
    }


    public int rob(int[] nums) {
        if (nums.length > 0) {
            if (nums.length == 1) return nums[0];
            else if (nums.length == 2) return 0;
            else if (nums.length == 3) return nums[1];
            return Math.max(getMax(nums, 0, nums.length - 1), getMax(nums, 1, nums.length - 1));
        }
        return 0;
    }

    private int getMax(int[] nums, int start, int n) {
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
        }
        return dp[n - 1];
    }
}
