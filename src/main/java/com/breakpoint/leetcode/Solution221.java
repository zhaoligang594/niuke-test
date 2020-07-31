package com.breakpoint.leetcode;

/**
 * 221. 最大正方形
 * middle
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/14
 */
public class Solution221 {
    /*
        在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

        示例:

        输入:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        输出: 4
        通过次数60,586提交次数142,515

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/maximal-square
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

        int i = new Solution221().maximalSquare(matrix);
        System.out.println(i);
    }


    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0, width = matrix.length, height = matrix[0].length;
        int[][] dp = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
