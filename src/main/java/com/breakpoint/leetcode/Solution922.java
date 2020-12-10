package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/12
 */
public class Solution922 {

    public static void main(String[] args) {
        int[] A = {648, 831, 560, 986, 192, 424, 997, 829, 897, 843};
        int[] ints = new Solution922().sortArrayByParityII(A);
        System.out.println(ints);
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 0;
        for (; j < A.length; ) {
            for (; j < A.length; j++) {
                if (j % 2 == 1 && A[j] % 2 != 1) {
                    int i1 = seekNum(A, 1, j);
                    swap(A,j,i1);
                }
                if (j % 2 == 0 && A[j] % 2 != 0) {
                    int i1 = seekNum(A, 0, j);
                    swap(A,j,i1);
                };
            }
        }
        return A;
    }

    private int seekNum(int[] A, int tag, int start) {
        int res = start;
        for (int i = start; i < A.length; i++) {
            if (A[i] % 2 == tag) return i;
        }
        return res;
    }

    private void swap(int[] A, int i, int j) {
        if (i < A.length && j < A.length) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

}
