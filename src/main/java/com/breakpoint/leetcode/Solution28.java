package com.breakpoint.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/08
 */
public class Solution28 {

    public static void main(String[] args) {

        int i = new Solution28().strStr("hello", "lo");
        System.out.println(i);

        //System.out.println(Arrays.toString(getNext("abdcasd")));

    }

    public int strStr(String haystack, String needle) {
        if (null == needle || Objects.equals("", needle)) {
            return 0;
        }
        if (null == haystack || Objects.equals("", haystack)) {
            return -1;
        } else {
            return haystack.indexOf(needle);
        }
    }


    // 获取next序列
    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        //next[1] = 1;
        int i = 1, j = 0;
        for (; i <= str.length(); ) {
            if (j == 0 || str.charAt(i - 1) == str.charAt(j - 1)) {
                i++;
                j++;
                if (i - 1 < str.length()) {
                    next[i - 1] = j;
                }
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }


    // version tow KMP 算法
//    public int strStr(String haystack, String needle) {
//        if (null == needle || Objects.equals("", needle)) {
//            return 0;
//        }
//
//        if (null == haystack || Objects.equals("", haystack)) {
//            return -1;
//        } else {
//            // 采用快速查找的方式
//            final int haystackLen = haystack.length();
//            final int needleLen = needle.length();
//
//            int[] next = getNext(needle);
//
//            int start = 1, end = 1;
//
//            for (; start <= haystackLen && end <= needleLen; ) {
//                if (end == 0 || haystack.charAt(start - 1) == needle.charAt(end - 1)) {
//                    start++;
//                    end++;
//                } else {
//                    end = next[end - 1];
//                }
//            }
//
//            if (end > needleLen) {
//                return start - needleLen - 1;
//            }
//            return -1;
//        }
//    }

    // one 普通的找
//    public int strStr(String haystack, String needle) {
//        if (null == needle || Objects.equals("", needle)) {
//            return 0;
//        }
//
//        if (null == haystack || Objects.equals("", haystack)) {
//            return -1;
//        } else {
//            int start = 0, end = 0;
//
//            final int haystackLen = haystack.length();
//            final int needleLen = needle.length();
//
//            for (; start < haystackLen; ) {
//                inner:
//                {
//                    for (; end < needleLen; ) {
//                        if (start < haystackLen && haystack.charAt(start) == needle.charAt(end)) {
//                            start++;
//                            end++;
//                        } else {
//                            break inner;
//                        }
//                    }
//                }
//                if (end == needle.length()) {
//                    return start - end;
//                } else {
//                    start = start - end + 1;
//                    end = 0;
//                }
//
//            }
//            return -1;
//        }
//    }
}
