package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/17
 */
public class Solution977 {

    public static void main(String[] args) {
        int[] A = {-3, -3, -2, 1};
        int[] ints = new Solution977().sortedSquares(A);
        System.out.println(ints);
    }

    public int[] sortedSquares(int[] A) {
        int index = 0, gap = Integer.MAX_VALUE, i = 0;
        if (A.length == 0) return A;
        for (; i < A.length && Math.abs(A[i]) <= gap; i++) {
            gap = Math.abs(A[i]);
        }
        int l = i - 1, r = i;
        int[] res = new int[A.length];
        while (l >= 0 && r < A.length) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                res[index++] = A[r] * A[r];
                r++;
            } else {
                res[index++] = A[l] * A[l];
                l--;
            }
        }
        while (l >= 0) {
            res[index++] = A[l] * A[l];
            l--;
        }
        while (r < A.length) {
            res[index++] = A[r] * A[r];
            r++;
        }
        return res;
    }
}
