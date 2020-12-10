package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/12/03
 */
public class Solution680 {

    public static void main(String[] args) {
        boolean abca = new Solution680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        System.out.println(abca);
    }

    public boolean validPalindrome(String s) {
        if (s.length() < 2) return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                boolean flag1 = true, flag2 = true;
                int low = start;
                int high = end;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
