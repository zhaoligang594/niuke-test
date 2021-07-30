package com.breakpoint.offer;

import java.util.Arrays;

public class Offer50 {

    public char firstUniqChar(String s) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (arr[ch - 'a'] == 0) {
                arr[ch - 'a'] = ch;
            } else if (arr[ch - 'a'] > 0) {
                arr[ch - 'a'] = -1;
            }
        }
        for (char ch : chars) {
            if (arr[ch - 'a'] > 0) {
                return ch;
            }
        }
        return ' ';
    }
}
