package com.breakpoint.leetcode2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1104 {

    public static void main(String[] args) {
        List<Integer> integers = new Solution1104().pathInZigZagTree(26);
    }

    /**
     * 分为 奇偶的分类 之后进行 求解
     */
    public List<Integer> pathInZigZagTree(int label) {
        // 1。 求label的深度
        int depth = 0, k = label;
        while (k >= 1) {
            depth++;
            k = k >> 1;
        }
        // 2。 求每一层的节点的标志
        Deque<Integer> stack = new ArrayDeque<>();
        // 获取真实的数字
        stack.addLast(getTargetNumber(label, depth));
        // 获取每一链路上的数据
        while (depth > 1) {
            stack.addLast(stack.peekLast() >> 1);
            depth--;
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(getTargetNumber(stack.pollLast(), depth++));
        }
        return res;
    }

    // 获取镜像位置
    private int getTargetNumber(int label, int depth) {
        if (depth % 2 == 1) return label;
        else {
            int preNum = (int) Math.pow(2, depth - 1) - 1;
            int curNum = (int) Math.pow(2, depth) - 1;
            return curNum - (label - preNum) + 1;
        }
    }
}
