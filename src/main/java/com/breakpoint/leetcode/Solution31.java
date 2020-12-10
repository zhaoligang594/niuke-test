package com.breakpoint.leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/28
 */
public class Solution31 {

    /*
        实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

        必须原地修改，只允许使用额外常数空间。

        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1

        通过次数84,298提交次数244,905

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/next-permutation
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || 0 == nums.length || 1 == nums.length) return;

        int index = nums.length - 1, monitor = nums[index];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }

        if (index == nums.length - 1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int next = index;
            for (int i = index+1; i < nums.length; i++) {
                if (nums[i] <= nums[index]) {
                    next = i - 1;
                    break;
                }
            }
            if (next == index) {
                next = nums.length - 1;
            }
            int num = nums[index];
            nums[index] = nums[next];
            nums[next] = num;
            reverse(nums, index + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int num = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = num;
        }
    }
}
