package com.breakpoint.offer;

import com.breakpoint.annotation.Success;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 在排序数组中查找数字 I
 */
@Success
public class Offer53_1 {

    public int search(int[] nums, int target) {
        int b = getIndex(nums, target, true);
        int s = getIndex(nums, target, false);
        return b - s;
    }

    private int getIndex(int[] nums, int target, boolean bigger) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (bigger) {
                start++;
            } else {
                end--;
            }
        }
        return start;
    }
}
