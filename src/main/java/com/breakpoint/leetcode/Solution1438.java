package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-22
 */
public class Solution1438 {

    public static void main(String[] args) {

    }

    //
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minStack = new ArrayDeque<>();
        minStack.addLast(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums[minStack.peekLast()]) {
                minStack.addLast(i);
            }
        }
        int start = 0, end = 0, min = 0, max = 0, res = 0;
        while (end < nums.length) {
            while (nums[max] - nums[min] <= limit) {
                if (nums[min] > nums[end]) {
                    min = end;
                }
                if (nums[max] < nums[end]) {
                    max = end;
                }
                end++;
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}
