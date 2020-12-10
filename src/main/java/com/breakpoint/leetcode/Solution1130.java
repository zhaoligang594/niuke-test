package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author breakpoint/赵先生
 * 2020/10/21
 */
public class Solution1130 {

    public static void main(String[] args) {
        int[] arr = {6,15,5,2};
        int i = new Solution1130().mctFromLeafValues(arr);
        System.out.println(i);
    }

//    public int mctFromLeafValues(int[] arr) {
//        Stack<Integer> stack = new Stack();
//        stack.push(Integer.MAX_VALUE);
//        int ans = 0;
//        for (int n : arr) {
//            while (stack.peek() < n) ans += stack.pop() * Math.min(stack.peek(), n);
//            stack.push(n);
//        }
//        while (stack.size() > 2) ans += stack.pop() * stack.peek();
//        return ans;
//    }

    public int mctFromLeafValues(int[] arr) {
        if (arr.length == 1) return 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() < arr[i]) {
                res += stack.pollLast() * Math.min(arr[i], stack.peekLast());
            }
            stack.addLast(arr[i]);
        }
        while (stack.size() > 2) {
            res += stack.pollLast() * stack.peekLast();
        }
        return res;
    }
}
