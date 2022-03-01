package com.breakpoint.daily;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : breakpoint
 * create date : 2022/01/18
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution539 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("23:59", "00:00");
        int minDifference = new Solution539().findMinDifference(list);
        System.out.println(minDifference);
    }

    // 23:12
    private int getValue(String timePoint) {
        int hour = Integer.parseInt(timePoint.substring(0, 2));
        int min = Integer.parseInt(timePoint.substring(3));
        return hour * 60 + min;
    }

    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (String timePoint : timePoints) {
            heap.offer(getValue(timePoint));
        }
        int pre = heap.poll();
        int start = pre, end = -1;
        int res = Integer.MAX_VALUE;
        int mod = 24 * 60; // 24小时
        while (!heap.isEmpty()) {
            int next = heap.poll();
            res = Math.min(res, next - pre);
            pre = next;
            if (heap.isEmpty()) {
                end = next;
            }
        }
        return Math.min(res, start + mod - end);
    }
}
