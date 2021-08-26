package com.breakpoint.leetcode2;

import com.breakpoint.utils.CharArrUtils;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/21
 */
public class Solution443 {

    public static void main(String[] args) {
        String[] strs = {"a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "c"};
        char[] charArr = CharArrUtils.getCharArr(strs);
        int compress = new Solution443().compress(charArr);
        System.out.println(compress);
    }

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
