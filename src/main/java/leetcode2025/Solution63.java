package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution63 {

    public static void main(String[] args) {
        Solution63 sol = new Solution63();
        int i = sol.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dpPath = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dpPath[0][1] = 1;
        for (int i = 1; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dpPath[i][j] = 0;
                } else {
                    dpPath[i][j] = dpPath[i - 1][j] + dpPath[i][j - 1];
                }
            }
        }
        return dpPath[obstacleGrid.length][obstacleGrid[0].length];
    }
}
