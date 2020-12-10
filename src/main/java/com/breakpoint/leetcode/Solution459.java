package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/24
 */
@Success
public class Solution459 {

    /*
        给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

        示例 1:

        输入: "abab"

        输出: True

        解释: 可由子字符串 "ab" 重复两次构成。
        示例 2:

        输入: "aba"

        输出: False
        示例 3:

        输入: "abcabcabcabc"

        输出: True

        解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/repeated-substring-pattern
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        boolean abab = new Solution459().repeatedSubstringPattern("ababba");
        System.out.println(abab);
    }

    public boolean repeatedSubstringPattern(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        int len = s.length();
        char first = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char second = s.charAt(i);
            if (first == second) {
                if (len % (i) == 0) {
                    boolean isOk = true;
                    //int m = i;

                    for (int k = i; k < len; k++) {
                        if (s.charAt(k) != s.charAt(k - i)) {
                            isOk = false;
                            break;
                        }
                    }


//                    whileLabel:
//                    while (m < len)
//                        for (int k = 0; k < i && m < len; k++, m++) {
//                            if (s.charAt(k) != s.charAt(m)) {
//                                isOk = false;
//                                break whileLabel;
//                            }
//                        }
                    if (isOk) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
