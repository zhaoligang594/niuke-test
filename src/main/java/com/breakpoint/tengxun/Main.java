package com.breakpoint.tengxun;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 利用大根堆以及小根堆来求解中位数
 *
 * @author breakpoint/赵先生
 * 2020/09/06
 */
public class Main {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(((o1, o2) -> {
        return o2 - o1;
    }));
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((((o1, o2) -> {
        return o1 - o2;
    })));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        // 得到了n 个数
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 如何操作呢？？？？ 求解中位数
        for (int j = 0; j < n; j++) {
            putVal(nums[j]);
        }
        for (int i = 0; i < n; i++) {
            removeVal(nums[i]);
            System.out.println(getMiddleVal());
            putVal(nums[i]);
        }
    }

    // 交替的进行移动
    private static void removeVal(Integer val) {
        if (minHeap.remove(val)) {
            while (maxHeap.size() - minHeap.size() > 1) {
                Integer poll = maxHeap.poll();
                minHeap.offer(poll);
            }
        } else {
            maxHeap.remove(val);
            while (minHeap.size() - maxHeap.size() > 1) {
                Integer poll = minHeap.poll();
                maxHeap.offer(poll);
            }
        }
    }

    private static void putVal(int val) {
        minHeap.offer(val);
        while (minHeap.size() - maxHeap.size() > 1) {
            Integer poll = minHeap.poll();
            maxHeap.offer(poll);
        }
    }

    private static int getMiddleVal() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }


}
