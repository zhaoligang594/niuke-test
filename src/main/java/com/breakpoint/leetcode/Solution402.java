package com.breakpoint.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author breakpoint/赵先生
 * 2020/11/15
 */
public class Solution402 {
    public static void main(String[] args) {
        String s = new Solution402().removeKdigits("112", 1);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {

        Deque<Character> stack = new LinkedList<>();

        stack.addLast((char) ('9' + 1));

        for (int i = 0; i < num.length(); i++) {
            if (k >= 0) {
                while (!stack.isEmpty() && stack.peekLast() > num.charAt(i) && k >= 0) {
                    stack.pollLast();
                    k--;
                }
            }
            stack.addLast(num.charAt(i));
        }
        if (stack.peekFirst() == ('9' + 1)) {
            stack.pollFirst();
        }
        if (k >= 0) {
            while (!stack.isEmpty() && k >= 0) {
                stack.pollLast();
                k--;
            }
        }
        while (!stack.isEmpty() && stack.peekFirst() == ('0')) {
            stack.pollFirst();
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        String res = sb.toString();
        return "".equals(res) ? "0" : res;
    }
}
