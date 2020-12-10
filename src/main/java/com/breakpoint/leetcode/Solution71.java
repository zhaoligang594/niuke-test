package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/10/22
 */
public class Solution71 {

    public static void main(String[] args) {
        String s = new Solution71().simplifyPath("/../");
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        if (path.length() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/+");
        if (split.length > 1) {
            for (int i = 1; i < split.length; i++) {
                if ("..".equals(split[i])) {
                    if (!stack.isEmpty()) stack.pollLast();
                } else if (".".equals(split[i])) {
                    // nothing to do
                } else {
                    stack.addLast(split[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollFirst());
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }
}
