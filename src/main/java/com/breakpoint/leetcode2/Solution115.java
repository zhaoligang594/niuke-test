package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;

import java.util.*;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/11
 */
public class Solution115 {
}


// 最小栈的操作
@Success
class MinStack {

    /**
     * initialize your data structure here.
     */
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> numbers = new ArrayDeque<>();
    private Map<Integer, Integer> count = new HashMap<>();

    public MinStack() {

    }

    public void push(int val) {
        numbers.addLast(val);
        if (stack.isEmpty() || stack.peekLast() > val) {
            stack.addLast(val);
        }
        if (val == stack.peekLast()) count.put(stack.peekLast(), count.getOrDefault(stack.peekLast(), 0) + 1);
    }

    public void pop() {
        Integer last = numbers.pollLast();
        if (last.equals(stack.peekLast())) {
            if (count.getOrDefault(last, 0) > 1) {
                //System.out.println(last+" "+count.get(last));
                count.put(last, count.get(last) - 1);
                //System.out.println(last+" "+count.get(last));
            } else {
                stack.pollLast();
            }
        }
    }

    public int top() {
        return numbers.peekLast();
    }

    public int getMin() {
        return stack.peekLast();
    }
}
