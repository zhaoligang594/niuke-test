package com.breakpoint.leetcode;

/**
 * 字符串的匹配问题
 *
 * @author breakpoint/赵先生
 * 2020/10/07
 */
public class Solution10 {

    public static void main(String[] args) {
        boolean match = new Solution10().isMatch("aa", "a*");
        System.out.println(match);
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0 && s.length() == 0) return true;
        if (p.length() == 0) return false;
        if (p.startsWith("*")) return false;
        int row = s.length() + 1;
        int col = p.length() + 1;
        boolean[][] dp = new boolean[row][col];
        dp[0][0] = true;
        for (int i = 0; i < col - 1; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            } else {
                dp[0][i + 1] = false;
            }
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (dp[i + 1][j - 1]) {
                        dp[i + 1][j + 1] = true;
                    } else if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
