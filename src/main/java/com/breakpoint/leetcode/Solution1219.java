package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

/**
 * 1219. 黄金矿工
 *
 * @author breakpoint/赵先生
 * 2020/09/07
 */
public class Solution1219 {

    /*
        https://leetcode-cn.com/problems/path-with-maximum-gold/
     */

    public static void main(String[] args) {
        //int[][] gridByString = GridUtils.getGridByString("[[0,6,0],[5,8,7],[0,9,0]]");
        int[][] gridByString = GridUtils.getGridByString("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]");
        int maximumGold = new Solution1219().getMaximumGold(gridByString);
        System.out.println(maximumGold);
    }

    int res = Integer.MIN_VALUE;
    boolean[][] tag;
    public int getMaximumGold(int[][] grid) {
        if (null == grid || grid.length == 0) return 0;
        tag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) dfs(grid, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int curSum) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 0
                && !tag[i][j]) {
            tag[i][j] = true;
            dfs(grid,i+1,j,curSum+grid[i][j]);
            dfs(grid,i-1,j,curSum+grid[i][j]);
            dfs(grid,i,j+1,curSum+grid[i][j]);
            dfs(grid,i,j-1,curSum+grid[i][j]);

            tag[i][j] = false;
        } else {
            res = Math.max(res, curSum);
        }
    }
}
