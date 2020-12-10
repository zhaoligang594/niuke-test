package com.breakpoint.leetcode;

import java.util.PriorityQueue;

/**
 * @author breakpoint/赵先生
 * 2020/10/10
 */
public class Solution1332 {

    public static void main(String[] args) {
        int ababa = new Solution1332().removePalindromeSub("ababb");
        System.out.println(ababa);
    }

    private static char[] getCharArray(String s) {
        char[] res = new char[2 * s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = '#';
            } else {
                res[i] = s.charAt(i / 2);
            }
        }
        return res;
    }


    public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        char[] charArray = getCharArray(s);
        int[] radius = new int[charArray.length];
        int C = 0, R = -1;
        for (int i = 0; i < charArray.length; i++) {
            radius[i] = i < R ? Math.min(R - C, i - C) : 1;
            while (i - radius[i] >= 0 && i + radius[i] < charArray.length) {
                if (charArray[i + radius[i]] == charArray[i - radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            radius[i]--;
            // 修改当前的值
            if (i + radius[i] > R) {
                R = i + radius[i];
                C = i;
            }
        }
        return getCount(radius, 0, radius.length - 1);
    }

    private int getCount(int[] radius, int start, int end) {
        //System.out.println(start + " " + end);
        if (start >= end) return 0;
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (radius[max] < radius[i]) max = i;
        }
        return 1 + getCount(radius, start, max - radius[max]) +
                getCount(radius, max + radius[max], end);
    }


}
