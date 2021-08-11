package com.breakpoint.sort;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
public class HeapSortTest {

    /*
        heap sort 的核心就是调整我们的堆
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 9, 6, 7, 3, 8, -1};
        //new HeapSortTest().hSort(nums);
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void heapSort(int[] arr) {
        if (null == arr || arr.length == 1) return;
        // 组装大根对
        for (int i = 2; i < arr.length; i++) heapInsert(arr, i);
        for (int i = arr.length - 1; i > 0; i--) {
            //System.out.println(arr[0]);
            swap(arr, 0, i);
            //arr[0] = arr[i];
            heapify(arr, 0, i);
        }
    }


    // 创建大根堆的过程
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) /2]) {
            swap(arr, index, (index - 1) /2);
            index = (index - 1) /2;
        }
    }

    // 向下调整的操作
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index << 1 + 1;
        while (left < heapSize) {
            // 找到比较大的数
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 与自己进行比较 如果没有自己大 那么就不用进行操作了
            largest = arr[largest] > arr[index] ? largest : index;
            // 终止操作
            if (largest == index) break;
            // 进行交换的操作
            swap(arr, index, largest);
            // 修改我们的索引
            index = largest;
            // 计算新的值
            left = index << 1 + 1;
        }
    }

    private static void swap(int arr[], int i, int j) {
//        int num = arr[i];
//        arr[i] = arr[j];
//        arr[j] = num;
        // 交换2个数
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /*
        ===========================  下面是自己写的算法  上面是 左神的算法思路  ===================================
     */


    private void hSort(int[] nums) {
        for (int i = nums.length, pos = nums.length; i >= 1; i--) {
            upAdjust(nums, pos);
            System.out.println(nums[0]);
            nums[0] = nums[i - 1];
            pos--;
        }
    }

    /**
     * 调整为小根堆
     *
     * @param nums 数值
     * @param pos  最后的位置
     */
    private void upAdjust(int[] nums, int pos) {
        int index = pos / 2;
        // 进行调整
        while (index >= 1) {
            int swapIndex = -1;
            if ((swapIndex = getSwapIndex(nums, index, pos)) != -1) {
                if (nums[index - 1] > nums[swapIndex - 1]) {
                    int temp = nums[index - 1];
                    nums[index - 1] = nums[swapIndex - 1];
                    nums[swapIndex - 1] = temp;
                }
            }
            index--;
        }
    }

    // 获取交换位置
    private int getSwapIndex(int[] nums, int index, int pos) {
        int swapIndex = -1;
        if (2 * index + 1 <= pos) {
            swapIndex = nums[2 * index] > nums[2 * index - 1] ?
                    2 * index : 2 * index + 1;
        } else if (2 * index <= pos) {
            swapIndex = 2 * index;
        }
        return swapIndex;
    }

    // 向下调整  暂时没有用到
    @Deprecated
    private void downAdjust(int[] nums, int pos) {
        int num = nums[0];
        int swapIndex = 0;
        int index = 1;
        while (swapIndex != -1) {
            if ((swapIndex = getSwapIndex(nums, index, pos)) != -1) {
                if (nums[index - 1] > nums[swapIndex - 1]) {
                    int temp = nums[index - 1];
                    nums[index - 1] = nums[swapIndex - 1];
                    nums[swapIndex - 1] = temp;
                }
            }
            index = swapIndex;
        }
        nums[index - 1] = num;
    }
}
