package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/22
 */
public class Solution673 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        int numberOfLIS = new Solution673().findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[stack.peekLast()] > nums[i]) stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            res += findNumFromStart(nums, stack.pollLast());
        }
        return res;
    }

    int res = 0;

    private int findNumFromStart(int[] nums, int start) {
        res = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(start);
        dfs(nums, start + 1, deque);
        return res;
    }

    private void dfs(int[] nums, int start, Deque<Integer> deque) {
        if (start < nums.length) {
            if (nums[deque.peekLast()] < nums[start]) {
                deque.addLast(start);
                dfs(nums, start + 1, deque);
                //deque.pollLast();
            } else {
                List<Integer> temp = new ArrayList<>();
                Integer integer = deque.pollLast();
                temp.add(integer);
                while (start < nums.length && nums[start] <= nums[integer]) {
                    temp.add(start);
                    start++;
                }
                for (Integer index : temp) {
                    deque.addLast(index);
                    dfs(nums, start, deque);
                    deque.pollLast();
                }
            }
        } else {

            System.out.println(deque);
            res++;
        }
    }

}
