package com.breakpoint.shijie;

import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/09/18
 */
public class Main06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n <= 4 ? 5 : n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        if (n <= 4) {
            System.out.println(dp[n]);
        } else {
            for (int i = 5; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
