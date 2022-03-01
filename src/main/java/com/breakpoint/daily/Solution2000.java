package com.breakpoint.daily;

/**
 * @author : breakpoint
 * create date : 2022/02/02
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution2000 {

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        char[] words = word.toCharArray();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (words[i] == ch) {
                return sb.reverse().toString() + word.substring(i + 1);
            }
        }
        return word;
    }
}
