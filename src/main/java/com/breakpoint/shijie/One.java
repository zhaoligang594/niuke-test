package com.breakpoint.shijie;

import java.util.Stack;

/**
 * @author breakpoint/zlg
 * 2020/08/29
 */
public class One {

    public static void main(String[] args) {
        String s = new One().triCoding(123);
        System.out.println(s);
    }

    public String triCoding(int num) {
        Stack<Integer> stack = new Stack<>();

        while (num > 0) {
            stack.push(num % 3);
            num /= 3;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            switch (pop) {
                case 0: {
                    sb.append("@");
                    break;
                }
                case 1: {
                    sb.append("$");
                    break;
                }
                case 2: {
                    sb.append("&");
                    break;
                }
            }
        }
        return sb.toString();
    }
}
