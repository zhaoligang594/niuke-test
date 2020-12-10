package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author breakpoint/赵先生
 * 2020/10/31
 */
public class Solution1262 {

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        int i = new Solution1262().maxSumDivThree(nums);
        System.out.println(i);
    }

    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ret = maxSumDivN(nums, 3);

        return ret;
    }

    private int maxSumDivN(int[] nums, int k) {
        // 获取到数组的长度
        int n = nums.length;
        // 创建动态规划的数组
        int[][] dp = new int[n + 1][k];
        // 设置初始值
        for (int j = 0; j < k; ++j) {
            dp[0][j] = 0;
        }
        // 设置标记位置
        boolean[] flag = new boolean[k];
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 0; j < k; ++j) {
                int sum = dp[i][j] + num;
                int ii = sum % k;
                flag[ii] = true;
                dp[i + 1][ii] = Math.max(sum, Math.max(dp[i + 1][ii], dp[i][ii]));
            }
            for (int j = 0; j < k; ++j) {
                if (flag[j]) flag[j] = false;
                else dp[i + 1][j] = dp[i][j];
            }
        }
        return dp[n][0];
    }
}
