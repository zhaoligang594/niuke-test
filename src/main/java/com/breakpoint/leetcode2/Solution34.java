package com.breakpoint.leetcode2;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/12
 */
public class Solution34 {

   /*
        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

        如果数组中不存在目标值 target，返回 [-1, -1]。

        进阶：

        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = new Solution34().searchRange(nums, 8);
    }

    // 34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftIndex = getLeftIndex(nums, target);
        if (leftIndex == nums.length || nums[leftIndex] != target) return ans;
        int rightIndex = getRightIndex(nums, target);
        return new int[]{leftIndex, rightIndex - 1};
    }


    private int getLeftIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int getRightIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
