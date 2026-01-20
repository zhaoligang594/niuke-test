package com.breakpoint.daily;

/**
 * https://leetcode.cn/problems/remove-duplicate-letters/
 */
public class Solution316 {

    public static void main(String[] args) {
        String bcabc = new Solution316().removeDuplicateLetters("bcabc");
        System.out.println(bcabc);
    }

    public String removeDuplicateLetters(String s) {
        int[] idx = new int[26];
        int[] sIdx = new int[s.length()];
        char minChar = s.charAt(s.length() - 1);
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) < minChar) {
                minChar = s.charAt(j);
            }
            if (idx[s.charAt(j) - 'a'] == 0) {
                idx[s.charAt(j) - 'a'] = j;
                sIdx[j] = 1;
            } else {
                int prevIdx = idx[s.charAt(j) - 'a'];
                if (s.charAt(j) < minChar) {
                    idx[s.charAt(j) - 'a'] = j;
                    sIdx[prevIdx] = 0;
                    sIdx[j] = 1;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sIdx.length; i++) {
            if (sIdx[i] != 0) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
