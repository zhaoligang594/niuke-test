package com.breakpoint.leetcode;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class Solution27 {
    /*
        给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-element
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int i = new Solution27().removeElement(nums, 2);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[start] == val && nums[end] != val) {
                nums[start] = nums[end];
                start++;
                end++;
            }else if(nums[start] == val && nums[end] == val){
                end++;
            }else{
                nums[start] = nums[end];
                start++;
                end++;
            }
        }
        return start + 1;
    }
}
