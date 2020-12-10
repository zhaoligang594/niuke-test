package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

/**
 * @author breakpoint/赵先生
 * 2020/11/26
 */
public class Solution1391 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[2],[2],[2],[2],[2],[2],[6]]");
        boolean b = new Solution1391().hasValidPath(gridByString);
        System.out.println(b);
    }

    public boolean hasValidPath(int[][] grid) {
        boolean[][] tag = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, tag);
    }

    /**
     * @param grid 原来的数据
     * @param i    当前的位置
     * @param j    当前的位置
     * @param tag  标志是否访问过
     * @return
     */
    public boolean dfs(int[][] grid, int i, int j, boolean[][] tag) {

        if (i == grid.length - 1 && j == grid[0].length - 1) return true;
        tag[i][j] = true;
        boolean res = false;

        switch (grid[i][j]) {
            case 1: {
                if (j - 1 >= 0 && !tag[i][j - 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6) {
                        res = res || dfs(grid, i, j - 1, tag);
                    }
                }
                if (j + 1 < grid[0].length && !tag[i][j + 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5) {
                        res = res || dfs(grid, i, j + 1, tag);
                    }
                }
                break;
            }
            case 2: {
                if (i + 1 < grid.length && !tag[i + 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6) {
                        res = res || dfs(grid, i + 1, j, tag);
                    }
                }
                if (i - 1 >= 0 && !tag[i - 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4) {
                        res = res || dfs(grid, i - 1, j, tag);
                    }
                }
                break;
            }
            case 3: {
                if (j - 1 >= 0 && !tag[i][j - 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6) {
                        res = res || dfs(grid, i, j - 1, tag);
                    }
                }
                if (i + 1 < grid.length && !tag[i + 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6) {
                        res = res || dfs(grid, i + 1, j, tag);
                    }
                }
                break;
            }
            case 4: {
                if (j + 1 < grid[0].length && !tag[i][j + 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5) {
                        res = res || dfs(grid, i, j + 1, tag);
                    }
                }
                if (i + 1 < grid.length && !tag[i + 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6) {
                        res = res || dfs(grid, i + 1, j, tag);
                    }
                }
                break;
            }
            case 5: {
                if (i - 1 >= 0 && !tag[i - 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4) {
                        res = res || dfs(grid, i - 1, j, tag);
                    }
                }
                if (j - 1 >= 0 && !tag[i][j - 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6) {
                        res = res || dfs(grid, i, j - 1, tag);
                    }
                }
                break;
            }
            case 6: {
                if (i - 1 >= 0 && !tag[i - 1][j]) {
                    // 有条件 并且没有访问过
                    if (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4) {
                        res = res || dfs(grid, i - 1, j, tag);
                    }
                }
                if (j + 1 < grid[0].length && !tag[i][j + 1]) {
                    // 有条件 并且没有访问过
                    if (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5) {
                        res = res || dfs(grid, i, j + 1, tag);
                    }
                }
                break;
            }
        }
        tag[i][j] = false;
        return res;
    }

}
