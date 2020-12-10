package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/10/22
 */
public class Solution946 {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean b = new Solution946().validateStackSequences(pushed, popped);
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.addLast(pushed[i]);
            while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                stack.pollLast();
                j++;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
