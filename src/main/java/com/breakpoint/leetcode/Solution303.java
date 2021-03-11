package com.breakpoint.leetcode;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-01
 */
public class Solution303 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int i = numArray.sumRange(2, 5);
        System.out.println(i);
    }

    static class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 2];
            sum[0] = 0;// -1
            if(nums.length>0){
                sum[1] = nums[0];// 0-0
                for (int i = 2; i < nums.length+1; i++) {
                    sum[i] = nums[i-1] + sum[i - 1];
                }
                sum[nums.length + 1] = sum[nums.length];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
