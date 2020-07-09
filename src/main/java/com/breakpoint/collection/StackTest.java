package com.breakpoint.collection;

import java.util.Stack;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/06
 */
public class StackTest {
    /*
            Stack : 也是我们熟悉的数据结构
            1. Java实现的底层是vector实现的：
            2. 底层的大小 默认是10
            3. 线程安全的操作类
     */

    public static void main(String[] args) {
        // define a stack
        Stack<Integer> stack=new Stack<>();
        // opt it
        stack.push(1);
        stack.push(2);

        System.out.println( stack.peek());


    }
}
