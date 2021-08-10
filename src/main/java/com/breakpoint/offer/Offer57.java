package com.breakpoint.offer;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/09
 */
public class Offer57 {

    // 原来就有序的 所以可以直接使用双指针的方式来求解
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[2];
    }
}
