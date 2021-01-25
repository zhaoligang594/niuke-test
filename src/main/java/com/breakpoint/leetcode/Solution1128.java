package com.breakpoint.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-25
 */
public class Solution1128 {

    public static void main(String[] args) {

    }

    private String getKey(int[] arr) {
        Arrays.sort(arr);
        return arr[0] + "_" + arr[1];
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] countArr = new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            countArr[a][b]++;
        }
        int res = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (countArr[i][j] > 1) {
                    res += (countArr[i][j] * (countArr[i][j] - 1)) / 2;
                }
            }
        }
        return res;
    }
}
