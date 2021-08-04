package com.breakpoint.leetcode2;

public class Solution55 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = new Solution55().canJump(nums);
    }

    public boolean canJump(int[] nums) {
        // 如果数组的长度是1  那么可以直接的返回
        if (nums.length == 1) return true;
        // 最远的地方的位置是多少
        int maxR = nums[0] + 1;
        // 分别的计算最远的地方 如果可以到达终点 那么可以操作
        for (int i = 1; i < maxR; i++) {
            if (maxR >= nums.length) break;
            if (nums[i] + i + 1 > maxR) {
                maxR = nums[i] + i + 1;
            }
        }
        return maxR >= nums.length;
    }
}
