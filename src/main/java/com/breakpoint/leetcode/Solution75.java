package com.breakpoint.leetcode;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 荷兰国旗的问题
 *
 * @author breakpoint/zlg
 * 2020/08/29
 */
public class Solution75 {

    /*
        给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

        注意:
        不能使用代码库中的排序函数来解决这道题。

        示例:

        输入: [2,0,2,1,1,0]
        输出: [0,0,1,1,2,2]
        进阶：

        一个直观的解决方案是使用计数排序的两趟扫描算法。
        首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
        你能想出一个仅使用常数空间的一趟扫描算法吗？

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/sort-colors
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 荷兰国旗的问题
    public void sortColors(int[] nums) {
        int less = -1, more = nums.length, cur = 0;
        while (cur < more) {
            if (nums[cur] < 1) {
                swap(nums, ++less, cur++);
            } else if (nums[cur] > 1) {
                swap(nums, --more, cur);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
