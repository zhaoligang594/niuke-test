package com.breakpoint.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/28
 */
public class Solution523 {

    // 根据官方题解的解决方法
    // 可以解释为 剩余的下标志是相同的
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] indexArr = new int[Integer.MAX_VALUE];
        indexArr[0] = -1;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int key = preSum % k;
            if (indexArr[key] != 0 && i - indexArr[key] >= 2) {
                return true;
            } else if (indexArr[key] == 0) {
                indexArr[key] = i;
            }
        }
        return false;
    }
}
