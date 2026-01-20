package leetcode2025;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class Solution714 {
//    public int maxProfit(int[] prices, int fee) {
//        int[][] dp = new int[prices.length + 1][3];
//        // 持有
//        dp[0][0] = -prices[0];
//        // 不持有
//        dp[0][1] = 0;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
//        }
//        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
//    }
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        // 持有
        dp[0] = -prices[0];
        // 不持有
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return Math.max(dp[0], dp[1]);
    }
}
