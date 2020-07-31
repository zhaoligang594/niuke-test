package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * 300. 最长上升子序列
 * middle
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/12
 */
@Success
public class Solution300 {

    /*
        给定一个无序的整数数组，找到其中最长上升子序列的长度。

        示例:

        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
        说明:

        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。
        进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

        通过次数114,698提交次数256,329

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = new Solution300().lengthOfLIS(nums);
        System.out.println(i);

    }

    // 定义动态规划的算法
    /*
       定义 dp[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 \textit{nums}[i]nums[i] 必须被选取。

        我们从小到大计算 dp[]dp[] 数组的值，在计算 dp[i]dp[i] 之前，我们已经计算出 dp[0 \ldots i-1]dp[0…i−1] 的值，则状态转移方程为：

        dp[i] = \text{max}(dp[j]) + 1, \text{其中} \, 0 \leq j < i \, \text{且} \, \textit{num}[j]<\textit{num}[i]
        dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]

        即考虑往 dp[0 \ldots i-1]dp[0…i−1] 中最长的上升子序列后面再加一个 \textit{nums}[i]nums[i]。由于 dp[j]dp[j] 代表 \textit{nums}[0 \ldots j]nums[0…j] 中以 \textit{nums}[j]nums[j] 结尾的最长上升子序列，所以如果能从 dp[j]dp[j] 这个状态转移过来，那么 \textit{nums}[i]nums[i] 必然要大于 \textit{nums}[j]nums[j]，才能将 \textit{nums}[i]nums[i] 放在 \textit{nums}[j]nums[j] 后面以形成更长的上升子序列。

        最后，整个数组的最长上升子序列即所有 dp[i]dp[i] 中的最大值。

        \text{LIS}_{\textit{length}}= \text{max}(dp[i]), \text{其中} \, 0\leq i < n
        LIS
        length
        ​
         =max(dp[i]),其中0≤i<n

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // 保存的是 以 i 结尾的最大增长的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
