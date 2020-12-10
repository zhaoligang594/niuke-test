package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/10/30
 */
public class Solution85 {

    public static void main(String[] args) {
    }

    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if (matrix.length > 0) {
            int[] dp = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                }
                res = Math.max(res, largestRectangleArea(dp));
            }
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;//面积
        if (heights.length > 0) {
            // 采用单调栈来进行实现
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addLast(0);
            for (int i = 1; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                    int pre = stack.pollLast();
                    int width = i - (stack.isEmpty() ? -1 : stack.peekLast()) - 1;
                    res = Math.max(res, width * heights[pre]);
                }
                stack.addLast(i);
            }
            while (!stack.isEmpty()) {
                int pre = stack.pollLast();
                int width = heights.length - (stack.isEmpty() ? -1 : stack.peekLast()) - 1;
                res = Math.max(res, width * heights[pre]);
            }
        }
        return res;
    }
}
