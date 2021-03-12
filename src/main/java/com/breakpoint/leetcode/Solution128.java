package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.HashSet;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/27
 */
@Success
public class Solution128 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        int i = new Solution128().longestConsecutive(nums);
        System.out.println(i);
    }

    // 求解最长的连续序列的求解方法 如何来进行展现
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            numSet.add(num);
        }
        int res = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int target = num, count = 0;
                while (numSet.contains(target)) {
                    target++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

}
