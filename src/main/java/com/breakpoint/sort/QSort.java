package com.breakpoint.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/06/30
 */
public class QSort {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3};
        qSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 快速排序算法
     *
     * @param arr 待排序的属猪
     * @param l   左边位置
     * @param r   右边位置
     */
    private static void qSort(int[] arr, int l, int r) {
        if (l < r) {
            int partition = getPartition(arr, l, r);
            qSort(arr, l, partition - 1);
            qSort(arr, partition + 1, r);
        }
    }

    /**
     * 荷兰国旗的问题
     *
     * @param arr 排序数组
     * @param l   左边位置
     * @param r   右边位置
     * @return 返回分割好后的中间位置
     */
    private static int getPartition(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) l++;
            arr[r] = arr[l];
        }
        arr[r] = temp;
        return l;
    }
}
