package com.breakpoint.test20201025;

import com.breakpoint.utils.GridUtils;

/**
 * @author breakpoint/赵先生
 * 2020/10/25
 */
public class Main03 {

    public static void main(String[] args) {
        int[][] heights = GridUtils.getGridByString("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]");
        int i = new Main03().minimumEffortPath(heights);
        System.out.println(i);
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] dp = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (i > 0 && j > 0) {
                    int temp1 = Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j]));
                    int temp2 = Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1]));
                    dp[i][j] = Math.min(temp1, temp2);
                } else if (i == 0 && j != 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1]));
                } else if (j == 0 && i != 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j]));
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[heights.length - 1][heights[0].length - 1];

    }
}
