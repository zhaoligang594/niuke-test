package com.breakpoint.leetcode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-23
 */
public class Solution1052 {

    public static void main(String[] args) {
        int[] customers = {1, 7};
        int[] grumpy = {1, 1};
        int i = new Solution1052().maxSatisfied(customers, grumpy, 1);
        System.out.println(i);
    }

    // 求解满意的最大人数
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) res += customers[i];
        }
        // 下面采用滑动窗口
        int left = 0, right = 0, max = 0;
        // bug fix
        max = Math.max(res, max);
        while (right < customers.length) {
            if (grumpy[right] == 1) {
                res += customers[right];
            }
            // 跨度是X
            if (right - left == X - 1) {
                max = Math.max(res, max);
                if (grumpy[left] == 1) {
                    res -= customers[left];
                }
                left++;
            }
            right++;
        }
        return max;
    }
}
