package com.breakpoint.leetcode2;

public class Solution171 {

    public int titleToNumber(String columnTitle) {
        int res = 0, sup = 1;
        char[] chars = columnTitle.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i] - 'A') * sup;
            sup *= 26;
        }
        return res + 1;
    }
}
