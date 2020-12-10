package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/08
 */
public class Solution797 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[4,3,1],[3,2,4],[3],[4],[]]");
        List<List<Integer>> lists = new Solution797().allPathsSourceTarget(gridByString);
        System.out.println(lists);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        dfs(graph, 0, deque);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    // 深度的递归操作
    public void dfs(int[][] graph, int start, Deque<Integer> deque) {
        int[] temp = graph[start];
        if (null != temp && temp.length > 0) {
            for (int i : temp) {
                deque.addLast(i);
                if (graph.length - 1 == i) {
                    res.add(new ArrayList<>(deque));
                } else {
                    dfs(graph, i, deque);
                }
                deque.pollLast();
            }
        }
    }
}
