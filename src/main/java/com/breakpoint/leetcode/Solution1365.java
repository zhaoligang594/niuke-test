package com.breakpoint.leetcode;

import java.util.PriorityQueue;

/**
 * @author breakpoint/赵先生
 * 2020/10/26
 */
public class Solution1365 {

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] ints = new Solution1365().smallerNumbersThanCurrent(nums);
        System.out.println(1);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new Node(i, nums[i]));
        }
        int[] res = new int[nums.length];
        int count = 0;
        Node pre = null;
        while (!minHeap.isEmpty()) {
            if (pre == null) {
                pre = minHeap.poll();
                res[pre.index] = count++;
            } else {
                if (minHeap.peek().val == pre.val) {
                    res[minHeap.peek().index] = res[pre.index];
                    pre = minHeap.poll();
                    count++;
                } else {
                    pre = minHeap.poll();
                    res[pre.index] = count++;
                }
            }
        }
        return res;
    }

    class Node {
        public int index;
        public int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
