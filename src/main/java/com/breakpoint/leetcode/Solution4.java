package com.breakpoint.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * hard
 *
 * @author breakpoint/zlg
 * 2020/08/25
 */
public class Solution4 {

    /*
        给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
        请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
        你可以假设 nums1 和 nums2 不会同时为空。    
        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5
        通过次数245,837提交次数636,272

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = new Solution4().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k1 = (len) / 2 + 1;
        if (nums1.length == 0) {
            if (len % 2 == 0) {
                return (nums2[k1 - 1] + nums2[k1 - 2]) / 2.0;
            } else {
                return nums2[k1 - 1];
            }
        }
        if (nums2.length == 0) {
            if (len % 2 == 0) {
                return (nums1[k1 - 1] + nums1[k1 - 2]) / 2.0;
            } else {
                return nums1[k1 - 1];
            }
        }
        int i = searchK(nums1, nums2, k1);
        if (len % 2 == 0) {
            return (i + searchK(nums1, nums2, k1 - 1)) / 2.0;
        } else {
            return i;
        }
    }

    // 找到迪k大的数
    private int searchK(int[] nums1, int[] nums2, int k) {
        int a_index, b_index, a_start = 0, b_start = 0;
        while ((a_start < nums1.length && b_start < nums2.length) && k != 1) {
            int j = k / 2 - 1;
            if (j > nums1.length - 1) {
                a_index = nums1.length - 1;
            } else {
                a_index = j;
            }
            if (j > nums2.length - 1) {
                b_index = nums2.length - 1;
            } else {
                b_index = j;
            }
            if (nums1[a_index + a_start] <= nums2[b_index + b_start]) {
                // 说明 0～a_index 没有第K个数
                a_start = a_index + a_start + 1;
                k = k - a_index - 1;
            } else {
                b_start = b_index + b_start + 1;
                k = k - b_index - 1;
            }
        }
        if (k == 1) {
            if (a_start < nums1.length && b_start < nums2.length) {
                if (nums1[a_start] > nums2[b_start]) {
                    return nums2[b_start];
                } else {
                    return nums1[a_start];
                }
            } else if (a_start >= nums1.length && b_start < nums2.length) {
                return nums2[b_start];
            } else {
                return nums1[a_start];
            }
        } else {
            if (a_start < nums1.length) {
                return nums1[a_start + k - 1];
            } else {
                return nums2[b_start + k - 1];
            }
        }
    }

}
