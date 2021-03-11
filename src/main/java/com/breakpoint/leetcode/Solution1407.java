package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-09
 */
public class Solution1407 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast() == S.charAt(i)) {
                stack.pollLast();
            } else {
                stack.addLast(S.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
