package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/10/19
 */
public class Solution844 {

    public static void main(String[] args) {
        boolean b = new Solution844().backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }

    public boolean backspaceCompare(String S, String T) {
        return getRealString(S).equals(getRealString(T));
    }

    private String getRealString(String str) {
        if ("".equals(str)) return "";
        Deque<Character> deque = new ArrayDeque<>();
        for (Character ch : str.toCharArray()) {
            if (ch != '#') {
                deque.addLast(ch);
            } else {
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
