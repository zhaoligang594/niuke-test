package com.breakpoint.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/14
 */
public class Solution438 {

    public static void main(String[] args) {
        List<Integer> anagrams = new Solution438().findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }

    /**
     * 找到需要的位置
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) {
            tag[c - 'a']++;
        }
        int index = s.length(), len = p.length();
        if (len > index) return res;
        char[] chars = s.toCharArray();
        while (index >= 0) {
            int anagrams = findAnagrams(chars, len, index - 1);
            if (anagrams != -1) {
                res.add(anagrams);
            }
            index = index - 1;
        }
        return res;
    }

    // 对应的操作
    int[] tag = new int[26];

    private int findAnagrams(char[] s, int len, int end) {
        if (end - len + 1 < 0) return -1;
        int[] chs = new int[26];
        for (int i = end - len + 1; i <= end; i++) {
            chs[s[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != tag[i]) return -1;
        }
        return end - len + 1;
    }
}
