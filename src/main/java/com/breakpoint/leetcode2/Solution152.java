package com.breakpoint.leetcode2;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
public class Solution152 {


    public int maxProduct(int[] nums) {
        int ans = nums[0], maxF = nums[0], minF = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
