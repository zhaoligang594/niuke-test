package com.breakpoint.leetcode;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * middle
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/15
 */
public class Solution154 {
    /*
        假设按照升序排序的数组在预先未知的某个点上进行了旋转。

        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

        请找出其中最小的元素。

        注意数组中可能存在重复的元素。

        示例 1：

        输入: [1,3,5]
        输出: 1
        示例 2：

        输入: [2,2,2,0,1]
        输出: 0
        说明：

        这道题是 寻找旋转排序数组中的最小值 的延伸题目。
        允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 1};
        int min = new Solution154().findMin(nums);
        System.out.println(min);

    }

    // 1. 循环遍历
    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] < nums[n - 1]) {// 原来有序的
            return nums[0];
        } else {
            int min = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > nums[i]) {
                    return nums[i];
                }
            }
            return min;
        }
    }
}
