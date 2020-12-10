package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/01
 */
public class Solution238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = new Solution238().productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];

        }
        return res;
    }
}
