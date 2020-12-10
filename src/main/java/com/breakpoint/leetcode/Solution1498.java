package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;

import java.util.HashSet;
import java.util.Set;

/**
 * 1498. 满足条件的子序列数目
 * middle
 *
 * @author breakpoint/赵先生
 * 2020/09/05
 */
@Fail
public class Solution1498 {

    /*
        给你一个整数数组 nums 和一个整数 target 。

        请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。

        由于答案可能很大，请将结果对 10^9 + 7 取余后返回。


        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        int[] nums = {6, 10, 12, 3, 29, 21, 12, 25, 17, 19, 16, 1, 2, 24, 9, 17, 25, 22, 12, 22, 26, 24, 24, 11, 3, 7, 24, 5, 15, 30, 23, 5, 20, 10, 19, 20, 9, 27, 11, 4, 23, 4, 4, 12, 22, 27, 16, 11, 26, 10, 23, 26, 16, 21, 24, 21, 17, 13, 21, 9, 16, 17, 27};
        //int[] nums = {5,2,4,1,7,6,8};
        //[14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14]
        //22
        //[6,10,12,3,29,21,12,25,17,19,16,1,2,24,9,17,25,22,12,22,26,24,24,11,3,7,24,5,15,30,23,5,20,10,19,20,9,27,11,4,23,4,4,12,22,27,16,11,26,10,23,26,16,21,24,21,17,13,21,9,16,17,27]
        //26
        //int[] nums = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        int i = new Solution1498().numSubseq(nums, 26);
        System.out.println(i);
    }


    /**
     * 为啥不对呢？？？？
     */
    public int numSubseq(int[] nums, int target) {
        if (nums.length > 0) quickSort(nums, 0, nums.length - 1);
        int max = nums[nums.length - 1], lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int middle = (lo + hi) / 2;
            if (nums[middle] + max > target) {
                hi = middle;
            } else {
                lo = middle + 1;
            }
        }
        hi = nums.length - 1;
        //System.out.println(lo);
        //System.out.println(hi);
        long sum = (long) Math.pow(2, nums.length) - 1;
        Set<Integer> set = new HashSet<>();
        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                // 首先是端点
                if (set.add(i)) {
                    //System.out.println("执行了I" + i);
                    if (2 * nums[i] > target) sum--;
                }
                if (set.add(j)) {
                    //System.out.println("执行了J" + j);
                    if (2 * nums[j] > target) sum--;
                }
                if (nums[i] + nums[j] > target) {
                    long temp = (long) Math.pow(2, j - i - 1);
                    sum -= temp;
                }
            }
        }
        if (set.add(lo)) {
            //System.out.println("执行了X");
            if (2 * nums[lo] > target) sum--;
        }
        long mod = 1000000007L;
        sum %= mod;
        return (int) sum;
    }


    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = getPartition(nums, l, r);
            quickSort(nums, l, partition - 1);
            quickSort(nums, partition + 1, r);
        }
    }

    private int getPartition(int[] arr, int l, int r) {
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
