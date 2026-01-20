package leetcode2025;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return maxProfit;
    }
}
