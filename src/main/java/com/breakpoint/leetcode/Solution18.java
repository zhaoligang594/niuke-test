package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/05
 */
public class Solution18 {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        List<List<Integer>> lists = new Solution18().fourSum(nums, 0);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                int num2 = nums[j];
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k - 1] == nums[k]) continue;
                    int num3 = nums[k];
                    for (int m = k + 1; m < nums.length; m++) {
                        if (m > k + 1 && nums[m - 1] == nums[m]) continue;
                        int num4 = nums[m];
                        if (num1 + num2 + num3 + num4 == target) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(num1);
                            list.add(num2);
                            list.add(num3);
                            list.add(num4);
                            res.add(list);
                        }
                    }
                }
            }
        }

        return res;

    }
}
