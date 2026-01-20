package leetcode2025;

/**
 * @author 赵立刚
 * @email: zlgtop@163.com
 * create at: 2025/05/02
 */
public class Solution198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        // 偷
        dp[0][0] = nums[0];
        // 不偷
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i-1];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // f[i][0] 表示不偷第 i 家的结果
        // f[i][1] 表示  偷第 i 家的结果
        int[][] f = new int[n+1][2];
        f[1][0] = 0;        // 初始化不偷第 1 家
        f[1][1] = nums[0];  // 初始化  偷第 1 家
        for(int i = 1; i <= n; i++){
            // 不偷第 i 家 等于 不偷前一家 与 偷前一家 的最大值
            f[i][0] = Math.max(f[i-1][0], f[i-1][1]);
            //   偷第 i 家 等于 不偷前一家 与 偷当前家庭 的和
            f[i][1] = f[i-1][0] + nums[i-1];
        }
        // 偷最后一家 与 偷倒数第二家 最大值
        return Math.max(f[n][1], f[n-1][1]);
    }
}
