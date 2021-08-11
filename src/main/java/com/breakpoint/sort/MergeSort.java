package com.breakpoint.sort;

import java.util.Arrays;

/**
 * @author breakpoint/赵先生
 * 2020/11/28
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 9, 6, 7, 3, 8, -1};
        //new HeapSortTest().hSort(nums);
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序算法
     *
     * @param nums 待排序的数组
     */
    public static void mergeSort(int[] nums) {
        if (nums != null && nums.length >= 2) {
            //  其他的情况是不需要进行排序的
            mergeSort(nums, 0, nums.length - 1);
        }
    }

    /**
     * 进行归并排序
     *
     * @param nums  带排序数组
     * @param left  左边位置
     * @param right 右边位置
     */
    private static void mergeSort(int[] nums, int left, int right) {
        // 归并排序的算法 如何来做
        // 也即是说 两个有序的数组归并进行排序
        // 算法的是稳定的算法
        if (left != right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            // 合并操作
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            // 设置新值
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
        }
    }
}
