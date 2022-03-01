package com.breakpoint.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : breakpoint
 * create date : 2022/01/21
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution1345 {


    /*
            给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
            每一步，你可以从下标 i 跳到下标：
            i + 1 满足：i + 1 < arr.length
            i - 1 满足：i - 1 >= 0
            j 满足：arr[i] == arr[j] 且 i != j
            请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
            注意：任何时候你都不能跳到数组外面。
            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/jump-game-iv
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] arr = {25, -28, -51, 61, -74, -51, -30, 58, 36, 68, -80, -64, 25, -30, -53, 36, -74, 61, -100, -30, -52};
        int i = new Solution1345().minJumps(arr);
        System.out.println(i);
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        // 保存的是最小的索引O
        Map<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer pre = value2Index.get(arr[i]);
            if (null != pre) {
                dp[i] = Math.min(dp[i - 1], dp[pre]) + 1;
                if (dp[i] < dp[pre]) value2Index.put(arr[i], i);
                for (int j = i - 1; j >= pre && j + 1 < n; j--) {
                    dp[j] = Math.min(dp[j], dp[j + 1] + 1);
                }
            } else {
                value2Index.put(arr[i], i);
                if (i > 0) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        return dp[n - 1];
    }
}
