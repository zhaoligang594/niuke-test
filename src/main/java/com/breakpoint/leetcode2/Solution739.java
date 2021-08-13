package com.breakpoint.leetcode2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/13
 */
public class Solution739 {

    // 使用单调栈解决这个问题
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                Integer last = stack.pollLast();
                ans[last] = i - last;
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pollLast()] = 0;
        }
        return ans;
    }
}
