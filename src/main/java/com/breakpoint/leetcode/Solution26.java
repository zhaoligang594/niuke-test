package com.breakpoint.leetcode;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution26 {
    /*
        给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new Solution26().removeDuplicates(nums);
        System.out.println(i);
    }

    // 排序的数组 说明原来是有序的。。。
    // 返回数组的长度的
    public int removeDuplicates(int[] nums) {
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[start] != nums[end]) {
                start++;
                nums[start] = nums[end];
            }
            end++;
        }
        return start + 1;
    }
}
