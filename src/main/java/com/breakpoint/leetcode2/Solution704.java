package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/14
 */
public class Solution704 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
