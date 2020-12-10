package com.breakpoint.offer;

import com.breakpoint.utils.GridUtils;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class Offer47 {
    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[1,3,1],[1,5,1],[4,2,1]]");
        int i = new Offer47().maxValue(gridByString);
        System.out.println(i);
    }

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
