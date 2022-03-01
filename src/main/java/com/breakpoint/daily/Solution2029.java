package com.breakpoint.daily;

/**
 * @author : breakpoint
 * create date : 2022/01/20
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution2029 {

    public static void main(String[] args) {

    }

    /*
     public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/stone-game-ix/solution/shi-zi-you-xi-ix-by-leetcode-solution-kk5f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public boolean stoneGameIX(int[] stones) {
        int[] dp = new int[3];
        for (int stone : stones) {
            dp[stone % 3]++;
        }
        if (dp[0] % 2 == 0) return dp[1] >= 1 && dp[2] >= 1;
        return dp[1] - dp[2] > 2 || dp[2] - dp[1] > 2;
    }
}
