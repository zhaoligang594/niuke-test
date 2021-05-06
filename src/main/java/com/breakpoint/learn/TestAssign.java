package com.breakpoint.learn;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-04-01
 */
public class TestAssign {

    public static void main(String[] args) {
        // 表示 当前的类型是否是 参数里面的 本类 或者是 超类
        System.out.println(MyAssign.class.getPackage().getName());
    }

    static class MyAssign {

    }

    static class MyAssignB extends MyAssign {

    }
}
