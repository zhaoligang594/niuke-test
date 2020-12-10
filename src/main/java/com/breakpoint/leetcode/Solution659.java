package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;

import java.util.TreeMap;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
@Fail
public class Solution659 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 5, 7};
        boolean possible = new Solution659().isPossible(nums);
        System.out.println(possible);
    }

    public boolean isPossible(int[] nums) {
        TreeMap<Integer, Integer> countMap = new TreeMap<Integer, Integer>();
        for (Integer num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Integer count = 0, cur = countMap.firstKey();
        while (!countMap.isEmpty()) {
            while (countMap.containsKey(cur)) {
                if (countMap.get(cur) - 1 == 0) {
                    countMap.remove(cur);
                } else {
                    countMap.put(cur, countMap.get(cur) - 1);
                }
                count++;
            }
        }
        return false;

    }
}
