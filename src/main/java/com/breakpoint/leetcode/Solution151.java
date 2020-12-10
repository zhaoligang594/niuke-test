package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/03
 */
public class Solution151 {

    public static void main(String[] args) {
        String s = new Solution151().reverseWords("a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        if (null == s || "".equals(s.trim())) return s;
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
            } else {
                if(temp.length()>0){
                    sb.append(temp.reverse()).append(" ");
                    temp.delete(0, temp.length());
                }
            }
        }
        if(temp.length()>0){
            sb.append(temp.reverse()).append(" ");
            temp.delete(0, temp.length());
        }
        return sb.toString().trim();
    }

}
