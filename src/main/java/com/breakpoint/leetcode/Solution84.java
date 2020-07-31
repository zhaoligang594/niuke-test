package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/29
 */
public class Solution84 {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = new Solution84().largestRectangleArea(heights);
        System.out.println(i);
    }






    // 暴力的解法
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }
        return maxArea;
    }
}
