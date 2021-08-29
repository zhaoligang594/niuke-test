package com.breakpoint.daily;

/**
 * 1588. 所有奇数长度子数组的和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/29
 */
public class Solution1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for (int span = 1, left = 0; span < pre.length; span += 2) {
            while (span + left < pre.length) {
                ans += pre[span + left] - pre[left];
                left++;
            }
            left = 0;
        }
        return ans;
    }
}
