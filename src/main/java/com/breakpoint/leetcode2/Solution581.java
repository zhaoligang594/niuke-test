package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;

import java.util.Arrays;

@Success
public class Solution581 {

    /*  第一种情况   */
    public int findUnsortedSubarray1(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }


    /*  第二种方式   */
    public int findUnsortedSubarray2(int[] nums) {
        int maxn = Integer.MAX_VALUE, minn = Integer.MIN_VALUE, left = -1, right = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                maxn = nums[i];
            } else {
                right = i;
            }

            if (minn < nums[n - i - 1]) {
                maxn = nums[n - i - 1];
            } else {
                left = n - i - 1;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
