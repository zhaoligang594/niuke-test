package com.breakpoint.daily;

/**
 * 1556. 千位分隔数
 * https://leetcode-cn.com/problems/thousand-separator/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/29
 */
public class Solution1556 {

    // 千位分割数
    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1, count = 0; i >= 0; i--, count++) {
            sb.append(num.charAt(i));
            if (count != 0 && count % 3 == 0) sb.append('.');
        }
        if ('.' == sb.charAt(sb.length() - 1)) sb.delete(sb.length() - 1, sb.length());
        return sb.reverse().toString();
    }
}
