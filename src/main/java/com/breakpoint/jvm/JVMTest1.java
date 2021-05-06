package com.breakpoint.jvm;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-15
 */
public class JVMTest1 {

    private final int a;

    public JVMTest1(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        JVMTest1 jvmTest1 = new JVMTest1(3);
        System.out.println(jvmTest1.a);
    }
}
