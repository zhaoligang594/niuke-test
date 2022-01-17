package com.breakpoint.daily;

/**
 * @author : breakpoint
 * create date : 2022/01/15
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution1716 {

    public static void main(String[] args) {
        int area = new Solution1716().totalMoney(20);
        int area2 = new Solution1716().getArea(1, 2);
        System.out.println(area);
        System.out.println(area2);
    }

    public int totalMoney(int n) {
        int offset = n / 7;
        int k = n % 7;
        return getArea(1, 7) * offset + 7 * getArea(0, offset-1) + getArea(1, k) + k * (offset);

    }

    private int getArea(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }
}
