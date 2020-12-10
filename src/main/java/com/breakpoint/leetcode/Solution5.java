package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/06
 */
public class Solution5 {

    public static void main(String[] args) {
        String babad = new Solution5().longestPalindrome("aacabdkacaa");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        if (null == s || "".equals(s)) return "";
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            move(s, reverse, i);
        }
        for (int i = 0; i < s.length(); i++) {
            move(reverse, s, i);
        }
        return res;
    }

    String res = "";

    private void move(String data1, String data2, int i) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (; j <= i; j++) {
            if (data1.charAt(j) == data2.charAt(data2.length() - 1 - i + j)) {
                sb.append(data1.charAt(j));
            } else {
                int m = j - 1;//pre index
                int l = m - sb.length() + 1;
                if (l + m == i) {
                    if (res.length() < sb.length()) {
                        res = sb.toString();
                        //System.out.println(res);
                    }
                }
                sb.delete(0, sb.length());
            }
        }
        int m = j - 1;//pre index
        int l = m - sb.length() + 1;
        if (l + m == i) {
            if (res.length() < sb.length()) {
                res = sb.toString();
                //System.out.println(res);
            }
        }
    }
}
