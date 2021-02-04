package com.breakpoint.leetcode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-04
 */
public class Solution643 {

    //[9,7,3,5,6,2,0,8,1,9]
    //6
    public static void main(String[] args) {
        int[] nums = {9, 7, 3, 5, 6, 2, 0, 8, 1, 9};
        double maxAverage = new Solution643().findMaxAverage(nums, 6);
        System.out.println(maxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = 0, sum = 0, max = Integer.MIN_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            if (end - start + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return max * 1.0 / k;
    }
}
