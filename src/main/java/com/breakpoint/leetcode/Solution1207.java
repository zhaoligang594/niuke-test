package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.TreeSet;

/**
 * @author breakpoint/赵先生
 * 2020/10/28
 */
@Success
public class Solution1207 {

    // https://leetcode-cn.com/problems/unique-number-of-occurrences/
    public static void main(String[] args) {

    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] times = new int[1000 + 1000 + 1];
        for (Integer val : arr) {
            times[val + 1000]++;
        }
        TreeSet<Integer> timesSet = new TreeSet<>();
        for (int i = 0; i < times.length; i++) {
            if (times[i] == 0) continue;
            if (!timesSet.add(times[i])) return false;
        }
        return true;
    }
}
