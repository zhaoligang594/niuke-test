package com.breakpoint.sort;

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
        int[] nums = {1, 2, 4, 5, 9, 6, 7, 3, 8,-1};
        new HeapSortTest().hSort(nums);
    }

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
