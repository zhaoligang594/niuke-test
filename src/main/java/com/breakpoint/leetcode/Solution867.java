package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * 转换矩阵的操作
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-25
 */
@Success
public class Solution867 {

    public static void main(String[] args) {

    }

    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
