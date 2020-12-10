package com.breakpoint.offer;

import com.breakpoint.utils.GridUtils;

/**
 * @author breakpoint/赵先生
 * 2020/12/09
 */
public class Offer04 {

    //[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
    //5

    public static void main(String[] args) {
        int[][] martrix = GridUtils.getGridByString("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        boolean numberIn2DArray = new Offer04().findNumberIn2DArray(martrix, 5);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (matrix.length > 0 && matrix[0].length > 0) {
            while (i >= 0 && matrix[i][j] > target) i--;
            while (j < matrix[0].length && matrix[i][j] < target) {
                j++;
            }
            if (i >= 0 && j < matrix[0].length && matrix[i][j] == target) return true;
        }
        return false;
    }
}
