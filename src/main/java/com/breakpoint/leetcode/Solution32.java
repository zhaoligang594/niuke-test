package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author breakpoint/赵先生
 * 2020/10/20
 */
public class Solution32 {

    public static void main(String[] args) {
        int i = new Solution32().longestValidParentheses("((()))())");
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
