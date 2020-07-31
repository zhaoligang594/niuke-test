package com.breakpoint.leetcode;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/28
 */
public class Solution392 {
    public static void main(String[] args) {
        boolean subsequence = new Solution392().isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        int i = 0, j = 0;
        for (; i < len_s && j < len_t; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        if (i >= len_s) {
            return true;
        }
        return false;
    }
}
