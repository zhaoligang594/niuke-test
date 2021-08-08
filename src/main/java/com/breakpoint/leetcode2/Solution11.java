package com.breakpoint.leetcode2;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/08
 */
public class Solution11 {

    public static void main(String[] args) {

    }

    // 采用双指针的方式来求解这个问题
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[r], height[l]));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
