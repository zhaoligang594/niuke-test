package com.breakpoint.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * https://leetcode-cn.com/problems/contiguous-array/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/20
 */
public class Solution525 {

    // 利用前缀的方式求解
    public int findMaxLength(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            counter = nums[i] == 1 ? counter + 1 : counter - 1;
            if (map.containsKey(counter)) {
                ans = Math.max(ans, i - map.get(counter));
            } else {
                map.put(counter, i);
            }
        }
        return ans;
    }
}
