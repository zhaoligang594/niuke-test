package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

/**
 * 73. 矩阵置零
 *
 * @author breakpoint/赵先生
 * 2020/10/10
 */
public class Solution73 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[1,1,1],[1,0,1],[1,1,1]]");
        new Solution73().setZeroes(gridByString);
        System.out.println(1);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] tag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    tag[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tag[i][j]) {
                    for (int l = 0; l < m; l++) {
                        if (matrix[l][j] != 0) {
                            matrix[l][j] = 0;
                        }
                    }//end for
                    for (int l = 0; l < n; l++) {
                        if (matrix[i][l] != 0) {
                            matrix[i][l] = 0;
                        }
                    }//end for
                }
            }
        }
    }
}
