package com.breakpoint.leetcode;

/**
 * 33. 搜索旋转排序数组
 * middle
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/15
 */
public class Solution33 {

    /*
            假设按照升序排序的数组在预先未知的某个点上进行了旋转。

            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

            搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

            你可以假设数组中不存在重复的元素。

            你的算法时间复杂度必须是 O(log n) 级别。

            示例 1:

            输入: nums = [4,5,6,7,0,1,2], target = 0
            输出: 4
            示例 2:

            输入: nums = [4,5,6,7,0,1,2], target = 3
            输出: -1
            通过次数143,540提交次数374,958

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            [4,5,6,7,8,1,2,3]
8
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        int search = new Solution33().search(nums, target);
        System.out.println(search);
    }


    // 二分查找
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        if (n == 1 && nums[0] == target) return 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
