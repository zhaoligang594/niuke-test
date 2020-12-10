package com.breakpoint.leetcode;

/**
 * 344. 反转字符串
 *
 * @author breakpoint/赵先生
 * 2020/10/08
 */
public class Solution344 {



    public void reverseString(char[] s) {
        if (s.length > 1) {
            for (int i = 0; i < s.length / 2; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }
    }

}
