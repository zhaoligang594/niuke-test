package com.breakpoint.quickpow;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-10
 */
public class QuickPowTest {

    static {
        System.out.println("A");
    }

    {
        System.out.println("D");
    }

    {
        System.out.println("C");
    }


    static {
        System.out.println("B");
    }

    public static void main(String[] args) {
         new QuickPowTest();
    }

    // 快速幂的实现方式
    public static long pow(int m, int n, int mod) {
        long res = 1, base = mod;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= base;
            }
            base *= base;
            n >>= 1;
        }
        return res;
    }
}
