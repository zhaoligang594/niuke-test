package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/09
 */
public class Solution934 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[0,1,0],[0,0,0],[0,0,1]]");
        int i = new Solution934().shortestBridge(gridByString);
        System.out.println(i);
    }

    int res = Integer.MAX_VALUE;

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Set<Node> setA = new HashSet<>();
    Set<Node> setB = new HashSet<>();
    int[][] tag;

    public int shortestBridge(int[][] A) {
        int n = A.length;// 阶数
        if (n == 1) return 0;
        Set<Node> set = setA;
        tag = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    if (!set.isEmpty() && set == setA) set = setB;
                    dfs(A, i, j, set);
                }
            }
        }
        for (Node nodeA : setA) {
            for (Node nodeB : setB) {
                int temp = Math.abs(nodeA.x - nodeB.x) + Math.abs(nodeA.y - nodeB.y) - 1;
                res = Math.min(temp, res);
            }
        }
        return res;
    }

    public void dfs(int[][] A, int i, int j, Set<Node> set) {
        if (i >= 0 && j >= 0 && i < A.length && j < A.length && A[i][j] == 1 && tag[i][j] == 0) {
            set.add(new Node(i, j));
            tag[i][j] = 1;
            dfs(A, i + 1, j, set);
            dfs(A, i - 1, j, set);
            dfs(A, i, j + 1, set);
            dfs(A, i, j - 1, set);
        }
    }


}
