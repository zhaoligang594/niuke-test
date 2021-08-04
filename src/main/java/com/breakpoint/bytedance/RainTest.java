package com.breakpoint.bytedance;

/**
 * 接雨水
 * https://blog.csdn.net/qq_42247231/article/details/106482591
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/14
 */
public class RainTest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5, 1, 8};
        int trap = new RainTest().trap(nums);
        System.out.println(trap);
    }

    public int trap(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] l_Max = new int[nums.length];
        l_Max[0] = nums[0];
        int[] r_Max = new int[nums.length];
        r_Max[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            l_Max[i] = Math.max(nums[i], l_Max[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            r_Max[i] = Math.max(nums[i], r_Max[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            ans += Math.min(l_Max[i], r_Max[i]) - nums[i];
        }
        return ans;
    }

}
