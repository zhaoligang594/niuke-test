package com.breakpoint.leetcode;

/**
 * 53. 最大子序和
 *
 * @author :breakpoint/赵立刚
 * create on 2020/06/30
 */
public class Solution53 {
    /*
        给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

        示例:

        输入: [-2,1,-3,4,-1,2,1,-5,4],
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        进阶:

        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/maximum-subarray
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = new Solution53().maxSubArray(nums);
        System.out.println(i);
    }

    /*
        前面的所有加在一起 小于0 就是 纳闷 在它的后面 加上任何的一个数 都是 越来越小的
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], temp = nums[0];
        final int len = nums.length;
        for (int i = 1; i < len; i++) {
            final int val = nums[i];
            temp = temp <= 0 ? val : temp + val;
            max = Math.max(temp, max);
        }
        return max;
    }
}
