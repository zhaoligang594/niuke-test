package com.breakpoint.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/10
 */
public class Solution121 {

    /*
        给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

        如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

        注意：你不能在买入股票前卖出股票。

         

        示例 1:

        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
             注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        示例 2:

        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
        通过次数236,889提交次数434,952

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public static void main(String[] args) {

        int[] prices = {7, 3, 5, 1, 6, 4};

        int i = new Solution121().maxProfit(prices);
        System.out.println(i);


    }

    // 动态规划的算法
    public int maxProfit(int[] prices) {
        int max = 0;
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[pre]) {
                int a = prices[i] - prices[i - 1];
                int b = prices[i] - prices[pre];
                if (a > b) {
                    pre = i - 1;
                } else {
                    a = b;
                }
                if (max < a) {
                    max = a;
                }
            } else {
                pre = i;
            }
        }
        return max;
    }
}
