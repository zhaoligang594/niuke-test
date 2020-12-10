package com.breakpoint.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author breakpoint/赵先生
 * 2020/11/22
 */
public class Solution242 {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            int num = count[ch - 'a'];
            if (num == 0) return false;
            count[ch - 'a']--;
        }
        return true;
    }
}
