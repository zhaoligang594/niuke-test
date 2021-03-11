package com.breakpoint.offer;

import com.breakpoint.annotation.Success;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-10
 */
@Success
public class Offer10_1 {

    public static void main(String[] args) {

    }

    // 快速的计算
    public int fib(int n) {
        if (n == 1 || n == 2) return 1;
        int res = 0, a = 1, b = 1;
        while (n > 2) {
            res = (a + b) % (1000000007);
            a = b;
            b = res;
            n--;
        }
        return res;
    }
}
