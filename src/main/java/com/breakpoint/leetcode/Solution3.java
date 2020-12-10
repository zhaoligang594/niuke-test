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

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int start = 0, end = 0, res = 0;
        Set<Character> set = new HashSet<>();
        for (; end < s.length(); ) {
            Character ch = s.charAt(end);
            if (set.add(ch)) {
                end++;
            } else {
                res = Math.max(res, end - start);
                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                set.add(ch);
                end++;
            }
        }
        res = Math.max(res, end - start);
        return res;
    }
}
