package com.breakpoint.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author breakpoint/赵先生
 * 2020/10/08
 */
public class Solution3 {

    public static void main(String[] args) {
        int abcabcbb = new Solution3().lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

    // 无重复字符的最长子串
    // 采用双指针的方式求解这个问题 一般 含有连续的字眼的题目都是采用双指针的方式来进行解决
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int left = 0, right = 0, res = 0;
        boolean[] tag = new boolean[26];
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!tag[ch - 'a']) {
                tag[ch - 'a'] = true;
                right++;
            } else {
                res = Math.max(res, right - left);
                while (s.charAt(left) != ch) {
                    tag[s.charAt(left) - 'a'] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        res = Math.max(res, right - left);
        return res;
    }
}
