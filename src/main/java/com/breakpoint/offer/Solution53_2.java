package com.breakpoint.offer;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-25
 */
public class Solution53_2 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        int i = new Solution53_2().missingNumber(nums);
        System.out.println(i);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        if(nums[n-2]!=n-1) return n-1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
