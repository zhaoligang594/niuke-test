package com.breakpoint.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/26
 */
public class Solution322 {

    /*
        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 

        示例 1:

        输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1
        示例 2:

        输入: coins = [2], amount = 3
        输出: -1
         

        说明:
        你可以认为每种硬币的数量是无限的。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/coin-change
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        /*
            [346,29,395,188,155,109]
9401
         */
        int[] coins = {346, 29, 395, 188, 155, 109};
        int i = new Solution322().coinChange(coins, 9401);
        System.out.println(i);
    }

    static Map<Integer, Integer> map = new HashMap<>();


    int res = Integer.MAX_VALUE;
    int[] tag;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        Arrays.sort(coins);
        tag = new int[amount + 1];
        return coinChange(coins, amount, coins.length - 1, 0);
    }

    // 自顶向下
    public int coinChange(int[] coins, int amount, int start, int count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (tag[amount] != 0) return tag[amount];
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                int res = coinChange(coins, amount - coins[i], i, count + 1);
                if (res >= 0 && res < min) min = res + 1;
            }
        }
        tag[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return tag[amount];
    }






    /*==================================================================================*/


    public int coinChange2(int[] coins, int amount) {
        Integer integer = map.get(amount);
        if (integer != null) {
            return integer;
        } else {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int sub = coinChange2(coins, amount - coin);
                map.put(amount - coin, sub);
                if (sub == -1) continue;
                res = Math.min(res, 1 + sub);

            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
