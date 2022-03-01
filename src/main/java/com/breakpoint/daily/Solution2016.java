package com.breakpoint.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : breakpoint
 * create date : 2022/02/26
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution2016 {

    public static void main(String[] args) {

    }


    public int maximumDifference(int[] nums) {
        int res = -1, curMin = 0;
        for (int i = 1; i < nums.length; i++) {
            res = nums[curMin] < nums[i] ? Math.max(nums[i] - nums[curMin], res) : res;
            curMin = nums[i] < nums[curMin] ? i : curMin;
        }
        return res;
    }
}
