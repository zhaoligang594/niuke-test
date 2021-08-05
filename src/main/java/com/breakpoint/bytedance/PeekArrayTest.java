package com.breakpoint.bytedance;

/**
 * 字节面试题：
 * 先递增后递减的数组中总共有多少个不同数字
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/03
 */
public class PeekArrayTest {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 1};
        int distinctNumber = new PeekArrayTest().getDistinctNumber(nums);
        System.out.println(distinctNumber);
    }

    /* 求解数组的 */
    public int getDistinctNumber(int[] nums) {
        int res = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                if (l == 0 || nums[l] != nums[l - 1]) res++;
                l++;
            } else if (nums[l] > nums[r]) {
                if (r == nums.length - 1 || (r < nums.length - 1 && nums[r] != nums[r + 1])) res++;
                r--;
            } else {
                if (l == 0 || nums[l] != nums[l - 1]) res++;
                r--;
                l++;
            }
        }
        return res;
    }
}
