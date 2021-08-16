package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/15
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r && !isChar(s.charAt(l))) l++;
            while (l < r && !isChar(s.charAt(r))) r--;
            if (getCh(s.charAt(l)) != getCh(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }

    private char getCh(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + ('a' - 'A'));
        }
        return ch;
    }

    private boolean isChar(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
