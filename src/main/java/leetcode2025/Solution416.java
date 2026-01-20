package leetcode2025;

import java.util.Arrays;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/05
 */
public class Solution416 {

    public static void main(String[] args) {
        boolean b = new Solution416().canPartition(new int[]{2, 2, 1, 1});
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 奇数
        if ((sum & 1) != 0) return false;
        int target = sum >> 1;
        boolean[][] dp = new boolean[target + 1][nums.length + 1];
        // 构成0情况
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[j][i] = dp[j][i - 1];
                if (j - nums[i - 1] >= 0) {
                    dp[j][i] = dp[j][i - 1] | dp[j][i - nums[i - 1]];
                }
            }
            if (dp[target][i]) {
                return true;
            }
        }
        return false;
    }
}
