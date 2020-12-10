package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class Solution463 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]");
        int i = new Solution463().islandPerimeter(gridByString);
        System.out.println(i);
    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0) {
                        if (grid[i - 1][j] == 1) res -= 2;
                    }
                    if (j > 0) {
                        if (grid[i][j - 1] == 1) res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
