package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/05
 */
public class Solution547 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[" +
                "[1,0,0,1]," +
                "[0,1,1,0]," +
                "[0,1,1,1]," +
                "[1,0,1,1]]");
        int circleNum = new Solution547().findCircleNum(gridByString);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    int k = i, temp = parent[j];
                    parent[j] = k;
                    while (parent[k] != k) {
                        k = parent[k];
                        parent[j] = k;
                    }
                    for (int m = 0; m < M.length; m++) {
                        if (parent[m] == temp) parent[m] = parent[j];
                    }
                }
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
            res.add(parent[i]);
        }
        return res.size();
    }
}
