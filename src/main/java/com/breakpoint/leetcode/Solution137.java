package com.breakpoint.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/13
 */
public class Solution137 {

    public static void main(String[] args) {
        int[] nums = {43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43};
        int i = new Solution137().singleNumber(nums);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        long total = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        for (Integer val : nums) {
            set.add(val);
            total += val;
        }
        for (Integer val : set) {
            sum += val;
        }
        return (int) ((3 * sum - total) / 2);
    }
}
