package com.breakpoint.offer;

import com.breakpoint.annotation.Success;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-10
 */
@Success
public class Offer13 {

    public static void main(String[] args) {
        int i = new Offer13().movingCount(38, 15, 9);
        System.out.println(i);
    }

    // 计算符合规格的
    // 采用动态规划实现这个题目
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][1] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (getSum(i - 1, j - 1) > k) {
                    continue;
                }
                if (dp[i][j - 1] || dp[i - 1][j]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    private int getSum(int i, int j) {
        return i % 10 + i / 10 % 10 + j % 10 + j / 10 % 10;
    }
}
