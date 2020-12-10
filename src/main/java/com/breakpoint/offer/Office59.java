package com.breakpoint.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class Office59 {

    // 定义一个可以求解最大值的队列
    static class MaxQueue {

        private class Node {
            public int val;
            public int count;

            public Node(int val, int count) {
                this.val = val;
                this.count = count;
            }
        }

        private Deque<Node> maxStack = new ArrayDeque<>();
        private Deque<Integer> vals = new ArrayDeque<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (maxStack.isEmpty()) return -1;
            else return maxStack.peekFirst().val;
        }

        public void push_back(int value) {
            vals.addLast(value);
            while (!maxStack.isEmpty() && maxStack.peekLast().val < value) {
                maxStack.pollLast();
            }

            if (!maxStack.isEmpty() && maxStack.peekLast().val == value) {
                maxStack.peekLast().count++;
            } else {
                maxStack.addLast(new Node(value, 1));
            }

        }

        public int pop_front() {
            if (vals.isEmpty()) return -1;
            Integer res = vals.pollFirst();
            if (res == maxStack.peekFirst().val) {
                if (maxStack.peekFirst().count == 1) {
                    maxStack.pollFirst();
                } else {
                    maxStack.peekFirst().count--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(15);
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());

    }
}
