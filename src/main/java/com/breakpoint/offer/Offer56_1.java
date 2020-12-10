package com.breakpoint.offer;

/**
 * @author breakpoint/赵先生
 * 2020/12/03
 */
public class Offer56_1 {

    public int[] singleNumbers(int[] nums) {
        int mask = 0;
        for (Integer num : nums) {
            mask ^= num;
        }
        int mask2 = mask & (-mask);
        int x = 0;
        for (Integer num : nums) {
            if ((num & mask2) != 0) x ^= num;
        }
        return new int[]{x, mask ^ x};
    }
}
