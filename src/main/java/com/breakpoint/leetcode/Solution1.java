package com.breakpoint.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2个数之和
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = new Solution1().twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    // 连个数相加
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (null != integer) {
                return new int[]{integer, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
