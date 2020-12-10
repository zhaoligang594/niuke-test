package com.breakpoint.leetcode;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/09/01
 */
public class Solution486 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        boolean b = new Solution486().PredictTheWinner(nums);
        System.out.println(b);
    }

    /*
        不太理解为什么是这样的情况
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }


}
