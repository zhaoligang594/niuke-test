package com.breakpoint.other;

import java.util.Arrays;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/04
 */
public class Main01 {

    public static void main(String[] args) {
        // 数组
        int[] nums = {-3, 6, 7, -4, 5, 5, -1, -9};

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] < 0) {
                // 偶数位上的
                int k = i;
                while (k < nums.length && nums[k] < 0) k++;
                if (k < nums.length) {
                    int swap = nums[i];
                    nums[i] = nums[k];
                    nums[k] = swap;
                }
            } else if (i % 2 == 1 && nums[i] > 0) {
                // 奇数位上的
                int k = i;
                while (k < nums.length && nums[k] > 0) k++;
                if (k < nums.length) {
                    int swap = nums[i];
                    nums[i] = nums[k];
                    nums[k] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(nums));


    }

}
