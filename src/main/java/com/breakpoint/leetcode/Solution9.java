package com.breakpoint.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/03
 */
public class Solution9 {

    /*
            判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */

    // 判断回文数
    public static void main(String[] args) {
        boolean palindrome = new Solution9().isPalindrome(121);
        System.out.println(palindrome);
    }

    // 回文串
    public boolean isPalindrome(int x) {
        String XStr = String.valueOf(x);
        int start = 0, end = XStr.length() - 1;
        while (start < end) {
            if (XStr.charAt(start) != XStr.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
