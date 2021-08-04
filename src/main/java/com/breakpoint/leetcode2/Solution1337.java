package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Fail;
import com.breakpoint.utils.GridUtils;

@Fail
public class Solution1337 {

    public static void main(String[] args) {
        //[[1,0],[1,0],[1,0],[1,1]]
        //4
        int[][] mat = GridUtils.getGridByString("[[1,0],[1,0],[1,0],[1,1]]");
        int[] ints = new Solution1337().kWeakestRows(mat, 4);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int m = mat.length;
        int n = mat[0].length;
        int index = 0;
        boolean[] tag = new boolean[m];
        tag:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!tag[j] && mat[j][i] == 0) {
                    res[index++] = j;
                    tag[j] = true;
                    if (index >= k) {
                        break tag;
                    }
                } else if (i == n - 1 && !tag[j]) {
                    res[index++] = j;
                }
            }
        }
        return res;
    }
}
