package com.breakpoint.learn;

import java.util.Arrays;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class JUCTest {


    public static void main(String[] args) {
        int[] seq = {1, 7, 7, 8, 3, 6, 7, 2};
        //int i = leastMagor(1, 2, 3, 4, 5);
        int i = countPoints(1);
        System.out.println(i);
    }

    // 19.
    public static int longestSequence(int[] seq) {
        if (seq.length < 2) return 1;
        int res = 0, l = 0, r = 1;
        while (r < seq.length) {
            if (seq[r - 1] >= seq[r]) {
                res = Math.max(res, r - l);
                l = r;
            }
            r++;
        }
        res = Math.max(res, r - l);
        return res;
    }

    // 20
    // import java.util.Arrays;
    public static int leastMagor(int a, int b, int c, int d, int e) {
        int[] nums = new int[]{a, b, c, d, e};
        Arrays.sort(nums);
        int res = 0;
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) count++;
            }
            if (count >= 2) return nums[i];
        }
        return res;
    }

    // 21 .
    public static int countPoints(int rSquare) {
        // 获取到半径
        int r = (int) Math.sqrt(rSquare), res = 0;
        for (int i = r - 1; i > 0; i--) {
            for (int j = r - i + 1; j < i + r; j++) {
                if (i * i + j * j == rSquare) {
                    res++;
                } else if (i * i + j * j > rSquare) {
                    break;
                }
            }
        }
        return res + 4;
    }


}
