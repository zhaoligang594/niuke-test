package com.breakpoint.leetcode;

/**
 * 746. 使用最小花费爬楼梯
 * simple
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author :breakpoint/赵立刚
 * create on 2020/07/13
 */
public class Solution746 {

    /*
            数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

            每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

            您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

            示例 1:

            输入: cost = [10, 15, 20]
            输出: 15
            解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
             示例 2:

            输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
            输出: 6
            解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int i = new Solution746().minCostClimbingStairs(cost);
        System.out.println(i);
    }

    /*
            思想：
            存储每一步的最小值 ，这一步的最小值 与 与前两个是密切相关的问题
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = Math.min(dp[0] + cost[1], cost[1]);
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            dp[i] += i < n ? cost[i] : 0;
        }
        return dp[n];
    }
}
