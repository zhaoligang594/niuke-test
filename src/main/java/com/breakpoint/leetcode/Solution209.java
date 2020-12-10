package com.breakpoint.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 209. 长度最小的子数组
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/12
 */
public class Solution209 {
    /*
        给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

       示例：

        输入：s = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
         
        进阶：

        如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = new Solution209().minSubArrayLen(7, nums);
        System.out.println(i);
    }


    // 采用队列的方式
    // 其他人想出来的
    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE, sum = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            queue.addFirst(nums[i]);
            while (sum >= s) {
                res = Math.min(res, queue.size());
                if(!queue.isEmpty())sum -= queue.pollLast();
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }


    // 打死也想不出来
    // 官方
    public int minSubArrayLenONE(int s, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
