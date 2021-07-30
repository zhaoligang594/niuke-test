package com.breakpoint.leetcode2;

import com.breakpoint.utils.GridUtils;

public class Solution1893 {

    public static void main(String[] args) {
        //[[1,50]]
        //1
        //50
        int[][] ranges = GridUtils.getGridByString("[[1,50]]");
        boolean covered = new Solution1893().isCovered(ranges, 1, 50);
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] tag = new boolean[51];
        for (int[] range : ranges) {
            for (int k = range[0]; k <= range[1]; k++) {
                tag[k] = true;
            }
        }
        for (int k = left; k <= right; k++) {
            if (!tag[k]) return false;
        }
        return true;
    }
}
