package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/03
 */
public class Solution198 {

    public static void main(String[] args) {

    }

    // 虽然是简单的题 但是感觉也是非常的难的
//    public int rob(int[] nums) {
//        if (nums.length > 0) {
//            if (nums.length == 1) return nums[0];
//            else if (nums.length == 2) return Math.max(nums[0], nums[1]);
//            int[] dp = new int[nums.length];
//            dp[0] = nums[0];
//            dp[1] = Math.max(nums[0], nums[1]);
//            for (int i = 2; i < nums.length; i++) {
//                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//            }
//
//            return dp[nums.length - 1];
//        }
//        return 0;
//    }

    public int rob(int[] nums) {
        if (nums.length > 0) {
            if (nums.length == 1) return nums[0];
            else if (nums.length == 2) return Math.max(nums[0], nums[1]);
            int pre = 0, next = 0;
            pre = nums[0];
            next = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int temp = Math.max(next, pre + nums[i]);
                pre = next;
                next = temp;
            }
            return next;
        }
        return 0;
    }
}
