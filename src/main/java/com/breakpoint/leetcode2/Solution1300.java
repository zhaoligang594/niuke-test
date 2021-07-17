package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Fail;

import java.util.Arrays;

@Fail
public class Solution1300 {

    public static void main(String[] args) {

    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE, res = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int k = arr.length - i;
            sum -= arr[i];
            if (sum < target) {
                int abs = sum - target;
                int m = abs / k;
                int n = m + 1;

            }
        }
        return res;
    }
}
