package leetcode2025;

import java.util.Arrays;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins = {2};
        int i = new Solution322().coinChange(coins, 3);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int infinity = Integer.MAX_VALUE - 2;
        // dp[i] 为 i的钱最少兑换的货币个数
        int[] dp = new int[amount + 1];
        // 显然 0 不需要 兑换
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = infinity;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] > infinity) {
                        // 说明 i - coins[j] 无法兑换
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > infinity ? -1 : dp[amount];
    }
}
