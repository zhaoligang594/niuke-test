package leetcode2025;

import com.breakpoint.utils.GridUtils;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/14
 */
public class Solution74 {

    public static void main(String[] args) {
        Solution74 sol = new Solution74();
        boolean b = sol.searchMatrix(GridUtils.getGridByString("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int top = 0, bottom = row - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        int left = 0, right = col;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[top][mid] == target) {
                return true;
            } else if (matrix[top][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
