package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 *
 * @author breakpoint/赵先生
 * 2020/10/26
 */
public class Solution845 {

    /**
     * 动态规划的求解过程
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        int i = new Solution845().longestMountain(A);
        System.out.println(i);
    }

    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
