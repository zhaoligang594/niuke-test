package com.breakpoint.shijie;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/22
 */
public class TriangleParttern {

    public static void f(int n) {
        if (n > 0) {
            Stack<String> stack = new Stack<>();
            int cur = 1, count = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                while (count<=i){
                    sb.append(cur).append("*");
                    cur++;
                    if (count == i) {
                        String substring = sb.toString().substring(0, sb.length() - 1);
                        System.out.println(substring);
                        stack.push(substring);
                        sb.delete(0, sb.length());
                        count = 0;
                        break;
                    }else {
                        count++;
                    }
                }
            }
            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }

    }

    public static void main(String[] args) {
        f(4);
    }
}
