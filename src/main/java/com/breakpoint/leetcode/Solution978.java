package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/27
 */
public class Solution978 {

    public static void main(String[] args) {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int i = new Solution978().maxTurbulenceSize(A);
        System.out.println(i);
    }

    public int maxTurbulenceSize(int[] A) {
        // 当前的值的变化的状态 是上升还是下降的状态
        boolean[] isUp = new boolean[A.length];
        // 以 i 位置结尾的 最长湍流子数组 的长度
        int[] dp = new int[A.length];
        // 默认第一个的长度是1
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < A.length; i++) {
            // 如果值是相同的 那么就设置为 1
            if (A[i] == A[i - 1]) {
                dp[i] = 1;
                continue;
            }
            // 真正的操作逻辑
            if (i > 1) {
                // 如果上一个是上升的状态 例如：3，4 那么就得期待下一个是下降的
                if (isUp[i - 1]) {
                    if (A[i] < A[i - 1]) {
                        dp[i] = dp[i - 1] + 1;
                        isUp[i] = false;
                    } else {
                        // 如果下一个不是下降的 那么就要 重新计算当前的长度
                        dp[i] = 2;
                        isUp[i] = true;
                    }
                } else {
                    // 与上面的逻辑是相反的
                    if (A[i] > A[i - 1]) {
                        dp[i] = dp[i - 1] + 1;
                        isUp[i] = true;
                    } else {
                        dp[i] = 2;
                        isUp[i] = false;
                    }
                }
            } else {
                // 初始的标记状态
                dp[i] = 2;
                isUp[i] = A[i] > A[i - 1];
            }
            // 设置返回值 返回的是最大的状态
            res = Math.max(res, dp[i]);
        }
        // 返回结果
        return res;
    }
}
