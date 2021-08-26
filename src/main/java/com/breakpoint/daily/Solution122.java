package com.breakpoint.daily;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/24
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
