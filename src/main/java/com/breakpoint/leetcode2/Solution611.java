package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Fail;

import java.util.Arrays;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/04
 */
@Fail
public class Solution611 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int i = new Solution611().triangleNumber(nums);
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == 0) continue;
                int a = nums[i], b = nums[j];
                int max = a + b, min = b - a;
                int maxIndex = binarySearchMaxIndex(nums, max - 1);
                int minIndex = binarySearchMinIndex(nums, min + 1);
                maxIndex = Math.min(maxIndex, nums.length);
                minIndex = Math.max(minIndex, j);
                res += maxIndex - minIndex - 1;
            }
        }
        return res;
    }

    private int binarySearchMaxIndex(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] > k ? l : l + 1;
    }

    private int binarySearchMinIndex(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > k) {
                r = mid - 1;
            } else if (nums[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] < k ? l : l - 1;
    }
}
