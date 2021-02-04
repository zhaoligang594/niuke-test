package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * middle
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-02
 */
public class Solution424 {

    //"AABABBACCCDDSSSKKKAD"
    //6
    public static void main(String[] args) {
        int abab = new Solution424().characterReplacement("AABABBACCCDDSSSKKKAD", 6);
        System.out.println(abab);
    }

    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, getMax(s, (char) ('A' + i), k));
            System.out.println(res);
        }
//        for (int i = 0; i < s.length(); i++) {
//            charCount[s.charAt(i) - 'A']++;
//        }
        return res;
    }

    // 获取将这个字符串变为target的时候 最长的代码
    private int getMax(String s, char target, int k) {
        int start = 0, end = 0, res = 0;
        Deque<Integer> index = new ArrayDeque<>();
        while (end < s.length() && s.charAt(end) != target) {
            end++;
        }
        start = end;
        while (end < s.length()) {
            while (end < s.length() && s.charAt(end) == target) {
                end++;
            }
            if (end < s.length() && k > 0) {
                index.addLast(end);
                k--;
                end++;
            } else {
                res = Math.max(res, end - start);
                start = index.peekFirst() + 1;
                k++;
            }
        }
        res = Math.max(res, end - start);
        return res;
    }


}
