package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author breakpoint/赵先生
 * 2020/10/27
 */
public class Solution239 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new Solution239().maxSlidingWindow(nums, 3);
        System.out.println(ints);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int pre = 0, cur = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        while (cur < nums.length) {
            if (cur - pre + 1 == k) {
                res[pre] = nums[stack.peekFirst()];
                pre++;
            }
            cur++;
            while (!stack.isEmpty() && cur < nums.length && nums[stack.peekLast()] < nums[cur]) {
                stack.pollLast();
            }
            stack.addLast(cur);
            if (pre > stack.peekFirst()) {
                stack.pollFirst();
            }
        }

        return res;
    }

}
