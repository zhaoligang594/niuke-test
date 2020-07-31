package com.breakpoint.leetcode;

/**
 * 334. 递增的三元子序列
 * middle
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/12
 */
public class Solution334 {

    /*
            给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

            数学表达式如下:

            如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
            使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
            说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

            示例 1:

            输入: [1,2,3,4,5]
            输出: true
            示例 2:

            输入: [5,4,3,2,1]
            输出: false
            通过次数20,001提交次数51,892

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean b = new Solution334().increasingTriplet(nums);
        System.out.println(b);
    }


    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] >= 3) {
                return true;
            }
        }
        return false;
    }


}
