package com.breakpoint.leetcode2;

import java.util.Arrays;

/**
 * 排序的问题的解决
 */
public class Solution1838 {
    public static void main(String[] args) {

    }

    /**
     * 采用计数的方式
     */
    public int maxFrequency(int[] nums, int k) {
        int[] count = new int[100_001];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
