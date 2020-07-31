package com.breakpoint.leetcode;

/**
 * 11. 盛最多水的容器
 * middle
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/14
 */
public class Solution11 {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int i = new Solution11().maxArea(height);
        System.out.println(i);

    }

    // 双指针的方法
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int ans = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }

            ans = Math.max(ans, area);
        }
        return ans;

    }
}
