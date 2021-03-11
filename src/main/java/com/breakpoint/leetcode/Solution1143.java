package com.breakpoint.leetcode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-09
 */
public class Solution1143 {

    public static void main(String[] args) {

    }

    // 求解最长公共子序列的操作方法
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 定义 dp [i][j] 的意思是 从 0 位 开始  已经最长的子序列的长度
        int[][] dp = new int[m + 1][n + 1];
        // 二次循环得到答案
        // O(M*N)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // 当前位相同的情况
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 当前位不同的情况
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        // 返回所有的 最长公共 子序列
        return dp[m][n];
    }
}
