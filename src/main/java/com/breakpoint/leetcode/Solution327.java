package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/07
 */
public class Solution327 {

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int i = new Solution327().countRangeSum(nums, -2, 2);
        System.out.println(i);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long[] dp = new long[nums.length];
        for (int i = 0; i < dp.length; i++) {
            if (i > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                long temp;
                if (j > i) {
                    temp = dp[j] - ((i > 0) ? dp[i - 1] : 0);
                } else {
                    temp = nums[i];
                }
                if (temp <= upper && temp >= lower) res++;
            }
        }
        return res;
    }

//    public int countRangeSum(int[] nums, int lower, int upper) {
//        int res = 0;
//        long[] dp = new long[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = i; j < dp.length; j++) {
//                if (j > i) {
//                    dp[j] = dp[j - 1] + nums[j];
//                } else {
//                    dp[j] = nums[i];
//                }
//                if (dp[j] <= upper && dp[j] >= lower) res++;
//            }
//        }
//        return res;
//    }

//    public int countRangeSum(int[] nums, int lower, int upper) {
//        int res = 0;
//        long[][] dp = new long[nums.length][nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = i; j < dp[i].length; j++) {
//                if (j > i) {
//                    dp[i][j] = dp[i][j - 1] + nums[j];
//                } else {
//                    dp[i][j] = nums[i];
//                }
//                if (dp[i][j] <= upper && dp[i][j] >= lower) res++;
//            }
//        }
//        return res;
//    }
}
