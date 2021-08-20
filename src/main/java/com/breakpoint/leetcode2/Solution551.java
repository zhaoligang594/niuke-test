package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/17
 */
public class Solution551 {

    public boolean checkRecord(String s) {
        int count = 0, pre = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') count++;
            if (ch == 'L') {
                pre++;
            } else {
                pre = 0;
            }
            if (pre >= 3) return false;
        }
        return count < 2;
    }
}
