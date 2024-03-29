package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/24
 */
@Success
public class Solution88 {

    /*
        给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 
        说明:

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
         

        示例:

        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出: [1,2,2,3,5,6]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/merge-sorted-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                m--;
            } else {
                nums1[k] = nums2[n - 1];
                n--;
            }
            k--;
        }

        while (n > 0 && k >= 0) {
            nums1[k] = nums2[n - 1];
            n--;
            k--;
        }
    }
}
