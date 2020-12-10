package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/27
 */
public class Solution128 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        int i = new Solution128().longestConsecutive(nums);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        if (nums.length > 0) {
            qSort(nums, 0, nums.length - 1);
            int[] dp = new int[nums.length];
            dp[0] = 1;
            res = Math.max(res, dp[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]){
                    dp[i] = dp[i - 1];
                    continue;
                }
                if (nums[i] - 1 == nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    private void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = getPartition(nums, l, r);
            qSort(nums, l, partition - 1);
            qSort(nums, partition + 1, r);
        }
    }

    private int getPartition(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp) r--;
            if (l < r) nums[l] = nums[r];
            while (l < r && nums[l] <= temp) l++;
            if (l < r) nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

}
