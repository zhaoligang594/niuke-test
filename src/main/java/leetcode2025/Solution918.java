package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-01-29
 */
public class Solution918 {

    public int maxSubarraySumCircular(int[] A) {
        int[] dp = new int[A.length];   //dp[i]用来记录以nums[i]结尾的最大子序列和
        dp[0] = A[0];                   //初始化dp
        int max = dp[0];                //最大子序列和
        int sum = A[0];                //整个数组的和

        //        求最大子序列和，见53题
        for (int i = 1; i < dp.length; i++) {
            sum += A[i];
            dp[i] = A[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
        }

        int min = 0;    //开始求A[1]~A[n-1]上的最小子序列和
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i] = A[i] + Math.min(0, dp[i - 1]);
            min = Math.min(dp[i], min);
        }
        return Math.max(sum - min, max);
    }
}
