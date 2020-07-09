package com.breakpoint.leetcode;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution35 {
    /*
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    */

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int i = new Solution35().searchInsert(nums, 5);
        System.out.println(i);
    }

    // return index
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        while (start < nums.length && nums[start] < target) start++;
        return start;
    }


}
