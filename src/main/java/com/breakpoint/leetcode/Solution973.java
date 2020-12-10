package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author breakpoint/赵先生
 * 2020/11/09
 */
public class Solution973 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[1,3],[-2,2]]");
        int[][] ints = new Solution973().kClosest(gridByString, 1);
        System.out.println(ints);
    }

    PriorityQueue<Node> minHeap = new PriorityQueue<Node>(((o1, o2) -> o1.val - o2.val));

    public int[][] kClosest(int[][] points, int K) {
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(new Node(points[i][0], points[i][1], points[i][0] * points[i][0] + points[i][1] * points[i][1]));
        }
        List<int[]> res = new ArrayList<>();
        while (K > 0) {
            Node poll = minHeap.poll();
            int[] temp = {poll.x, poll.y};
            res.add(temp);
            K--;
        }
        return res.toArray(new int[0][]);
    }

    private static class Node {
        public int x;
        public int y;
        public int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
