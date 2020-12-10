package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/11/27
 */
public class Solution714 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int i = new Solution714().maxProfit(prices, 2);
        System.out.println(i);
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
