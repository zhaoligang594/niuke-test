package com.breakpoint.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 求解区间的位置
 * 如何求解
 *
 * @author breakpoint/zlg
 * 2020/08/31
 */
public class Solution34 {

    /*
        34. 在排序数组中查找元素的第一个和最后一个位置
        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

        你的算法时间复杂度必须是 O(log n) 级别。

        如果数组中不存在目标值，返回 [-1, -1]。
        示例 1:

        输入: nums = [5,7,7,8,8,10], target = 8
        输出: [3,4]
        示例 2:

        输入: nums = [5,7,7,8,8,10], target = 6
        输出: [-1,-1]
        通过次数127,052提交次数315,639

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = new Solution34().searchRange(nums, 8);
        System.out.println(ints);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = getExtremeIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        int rightIdx = getExtremeIndex(nums, target, false) - 1;
        return new int[]{leftIdx, rightIdx};
    }

    // 求解最小的下标
    public static int getExtremeIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
