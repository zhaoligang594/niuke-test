package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * simple
 *
 * @author breakpoint/zlg
 * 2020/08/30
 */
public class Solution557 {

    /*
        557. 反转字符串中的单词 III
        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。



        示例：

        输入："Let's take LeetCode contest"
        输出："s'teL ekat edoCteeL tsetnoc"


        提示：

        在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public static void main(String[] args) {
        String s = new Solution557().reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        if (null == s || "".equals(s)) return "";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            sb2.append(sb1.append(split[i]).reverse()).append(" ");
            sb1.delete(0, sb1.length());
        }
        return sb2.toString().trim();
    }

    public String reverseWords2(String s) {
        if (null == s || "".equals(s)) return "";
        char[] chars = s.toCharArray();
        for (int i = 0, pre = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, pre, i - 1);
                pre = i + 1;
            }
        }
        return new String(chars, 0, chars.length);
    }

    private static void reverse(char[] arr, int i, int j) {
        if (j > i) {
            for (int k = 0; k < (j - i + 1) / 2; k++) {
                char temp = arr[i + k];
                arr[i + k] = arr[j - k];
                arr[j - k] = temp;
            }
        }
    }
}
