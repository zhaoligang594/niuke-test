package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/13
 */
public class Solution1614 {

    public static void main(String[] args) {

    }

    public int maxDepth(String s) {
        int res = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
                res = Math.max(res, temp);
            } else if (s.charAt(i) == ')') {
                temp--;
            }
        }
        return res;
    }
}
