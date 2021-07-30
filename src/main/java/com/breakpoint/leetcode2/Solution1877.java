package com.breakpoint.leetcode2;

import java.util.Arrays;

public class Solution1877 {

    public int minPairSum(int[] nums) {
        int[] arr = new int[100_001];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 0, index = 0; i < nums.length; i++) {
            while (arr[i] > 0) {
                nums[index++] = i;
                arr[i]--;
            }
        }
        int res = Integer.MIN_VALUE, l = 0, r = nums.length - 1;
        for (; l < r; l++, r--) {
            res = Math.max(res, nums[l] + nums[r]);
        }
        return res;
    }
}
