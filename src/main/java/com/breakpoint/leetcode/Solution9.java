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

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int len = (x + "").length();
            int[] temp = new int[len];
            for (int i = len - 1; i >= 0; i--) {
                temp[i] = x % 10;
                x /= 10;
            }
            for (int i = 0; i < len / 2; i++) {
                if (temp[i] != temp[len - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        } else if (x == 0) {
//            return true;
//        } else {
//
//            Stack<Integer> opts = new Stack<>();
//            int y = x;
//            while (y > 0) {
//                opts.push(y % 10);
//                y /= 10;
//            }
//            while (x > 0 && !opts.isEmpty()) {
//                final int k = x % 10;
//                if (k != opts.pop()) {
//                    return false;
//                }
//                x/=10;
//            }
//            if (opts.isEmpty()) {
//                return true;
//            }
//            return false;
//        }
//    }


}
