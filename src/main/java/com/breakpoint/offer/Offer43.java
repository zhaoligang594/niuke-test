package com.breakpoint.offer;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class Offer43 {
    public static void main(String[] args) {
        int i = new Offer43().countDigitOne(12);
        System.out.println(i);
    }

    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int tag = 1;
        for (int i = 1; i <= n; i++) {
            if (i == tag) {
                tag *= 2;
                dp[i] = 1;
            } else {
                dp[i] = dp[i - (tag / 2)] + 1;
            }
        }
        return dp[n];
    }
}
