package leetcode2025;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
