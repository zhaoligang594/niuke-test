package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * 最新采用的是manacher算法实现
 * 5. 最长回文子串
 *
 * @author breakpoint/赵先生
 * 2020/10/06
 */
@Success
public class Solution5 {

    public static void main(String[] args) {
        String babad = new Solution5().longestPalindrome("aacabdkacaa");
        System.out.println(babad);
    }

    // 求解最长的回文子串
    public String longestPalindrome(String s) {
        if (null == s || "".equals(s)) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }
        int max = 0, index = 0;
        // manacher 算法
        // C 是对应 R 的半径的中心的位置
        int R = -1, C = 0, N = sb.length();
        int[] radius = new int[sb.length()];
        for (int i = 0; i < N; i++) {
            int k = i > R ? 1 : Math.min(radius[2 * C - i], R - i);
            // 向外部扩展
            while (i - k >= 0 && i + k < N && sb.charAt(i - k) == sb.charAt(i + k)) k++;
            radius[i] = k - 1;
            if (i + radius[i] > R) {
                R = i + radius[i];
                C = i;
            }
            //  求解问题的需要
            if (radius[i] > max) {
                max = radius[i];
                index = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = index - max + 1; i < index + max; i += 2) {
            res.append(sb.charAt(i));
        }
        return res.toString();
    }
}
