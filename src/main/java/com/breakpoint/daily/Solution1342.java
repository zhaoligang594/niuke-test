package com.breakpoint.daily;

/**
 * @author : breakpoint
 * create date : 2022/01/31
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution1342 {

    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            res++;
        }
        return res;
    }
}
