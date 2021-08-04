package com.breakpoint.leetcode2;

public class Solution263 {

    public static void main(String[] args) {

    }

    public boolean isUgly(int n) {
        int[] nums = {2, 3, 5};
        while (n > 1) {
            boolean tag = false;
            for (int num : nums) {
                if (n % num == 0) {
                    n /= num;
                    tag = true;
                }
            }
            if (!tag) return false;
        }
        return n == 1;
    }
}
