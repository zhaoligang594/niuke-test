package com.breakpoint.leetcode;

import java.util.PriorityQueue;

/**
 * @author breakpoint/赵先生
 * 2020/11/26
 */
public class Solution164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer num : nums) {
            minHeap.offer(num);
        }
        int pre = minHeap.poll(), maxGap = Integer.MIN_VALUE;

        while (!minHeap.isEmpty()) {
            maxGap = Math.max(maxGap, minHeap.peek() - pre);
            pre = minHeap.poll();
        }
        return maxGap;
    }

}
