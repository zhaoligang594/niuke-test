package com.breakpoint.leetcode;

/**
 * 80. 删除排序数组中的重复项 II
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Solution80 {

    /*
        给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

        示例 1:

        给定 nums = [1,1,1,2,2,3],

        函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

        你不需要考虑数组中超出新长度后面的元素。
        示例 2:

        给定 nums = [0,0,1,1,1,1,2,3,3],

        函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。

        你不需要考虑数组中超出新长度后面的元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = new Solution80().removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            // 循环赋值的过程的操作
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;


//        int j = 1, count = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//
//            if (nums[i] == nums[i - 1]) {
//
//                count++;
//
//            } else {
//
//                count = 1;
//            }
//
//            if (count <= 2) {
//                nums[j++] = nums[i];
//            }
//        }
//        return j;
    }


}
