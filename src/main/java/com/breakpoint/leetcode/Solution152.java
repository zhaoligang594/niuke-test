package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/09/01
 */
public class Solution152 {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int i = new Solution152().maxProduct(nums);
        System.out.println(i);
    }


    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                imax=imax^imin;
                imin=imax^imin;
                imax=imax^imin;
//                int tmp = imax;
//                imax = imin;
//                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }

    // O(n^2)
    public int maxProduct3(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sub = 1;
            for (int j = i; j < nums.length; j++) {
                sub *= nums[j];
                max = Math.max(sub, max);
            }
        }
        return max;
    }

    /*  递归求解  */

    public void maxProduct(int[] nums, Deque<Integer> deque, int start) {
        if (start == nums.length) {
            deque.clear();
            return;
        }
        for (int i = start; i < nums.length; i++) {
            deque.addLast(nums[i]);
            //subList.add(new ArrayList<>(deque));
            maxProduct(nums, deque, i + 1);
            //deque.pollLast();
        }
    }

    /*==========================  下面求解的是子数组的最大值   ====================================*/


    public int maxProduct2(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        maxProduct2(nums, 0, 1);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public void maxProduct2(int[] nums, int start, int cur) {
        max = Math.max(max, cur);
        for (int i = start; i < nums.length; i++) {
            maxProduct2(nums, i + 1, cur * nums[i]);
        }
    }

}
