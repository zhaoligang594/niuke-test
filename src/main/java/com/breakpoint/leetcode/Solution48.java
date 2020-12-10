package com.breakpoint.leetcode;

/**
 * 48. 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/31
 */
public class Solution48 {

    /*
        给定一个 n × n 的二维矩阵表示一个图像。

        将图像顺时针旋转 90 度。

        说明：

        你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

        示例 1:

        给定 matrix =
        [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ],

        原地旋转输入矩阵，使其变为:
        [
          [7,4,1],
          [8,5,2],
          [9,6,3]
        ]
        示例 2:

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/rotate-image
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };
        new Solution48().rotate(matrix);
    }


    public void rotate(int[][] matrix) {
        int sA = 0, sB = 0, dC = matrix.length - 1, dD = matrix.length - 1;
        while (sA < dC) {
            rotate(matrix, sA++, sB++, dC--, dD--);
        }
    }

    // 旋转操作
    private void rotate(int[][] matrix, int a, int b, int c, int d) {
        for (int i = 0; i < (c - a); i++) {
            int temp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = temp;
        }
    }


}
