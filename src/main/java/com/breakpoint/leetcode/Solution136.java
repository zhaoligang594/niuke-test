package com.breakpoint.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/09
 */
@Deprecated
public class Solution136 {

    /*
        说明：
        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int i = new Solution136().singleNumber(nums);
        System.out.println(i);
    }


    public int singleNumber(int[] nums) {
        Map<Integer, Byte> map = new HashMap<>();
        Byte b = new Byte((byte) 1);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, b);
            }
        }
        return map.keySet().toArray(new Integer[0])[0];
    }
}
