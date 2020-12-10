package com.breakpoint.leetcode;

/**
 * 1004. 最大连续1的个数 III
 *
 * @author breakpoint/赵先生
 * 2020/10/08
 */
public class Solution1004 {

    /*
        [0,0,1,1,1,0,0]
        0
     */

    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 1, 0, 0};
        int i = new Solution1004().longestOnes(A, 1);
        System.out.println(i);
    }

    public int longestOnes(int[] A, int K) {
        // 设置初始值 开始位置 结束位置 以及返回值 和标识位
        int k = K, start = 0, end = 0, res = 0, tag = 3;
        if (K == 0) {
            // 特殊的标识位
            tag = 1;
        }
        for (; end < A.length; ) {
            if (A[end] == 1) {
                end++;
            } else if (A[end] == 0 && k > 0) {
                A[end] = tag;
                end++;
                k--;
            } else if (A[end] == 0 && k <= 0) {
                res = Math.max(res, end - start);
                while (start < A.length && (A[start] != tag)) {
                    start++;
                }
                if (start < A.length && A[start] == tag && tag == 3) {
                    A[start] = 0;
                    start++;
                    k++;
                    A[end] = tag;
                    k--;
                    end++;
                } else {
                    // 说明 K==0的，直接后移就可以了
                    start = end;
                    start++;
                    end++;
                }

            }
        }
        // 设置返回的最大值
        res = Math.max(res, end - start);
        // 返回结果
        return res;
    }
}
