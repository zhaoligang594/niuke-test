package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.*;

/**
 * 采用D算法进行计算
 * @author breakpoint/赵先生
 * 2020/10/28
 */
public class Solution787 {
    //10
    //[[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
    //6
    //0
    //7

    public static void main(String[] args) {
        int n = 10;
        int[][] flights = GridUtils.getGridByString("[[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]");
        int src = 6, dst = 0, k = 7;
        int cheapestPrice = new Solution787().findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<Integer>[] dstArr = new ArrayList[n];
        int[][] priceArr = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int src1 = flights[i][0];
            int dst1 = flights[i][1];
            int price = flights[i][2];
            if (dstArr[dst1] == null) dstArr[dst1] = new ArrayList<Integer>();
            //if (dstArr[src1] == null) dstArr[src1] = new ArrayList<Integer>();
            dstArr[dst1].add(src1);
            //dstArr[src1].add(dst1);
            priceArr[src1][dst1] = price;
            //priceArr[dst1][src1] = price;
        }
        dfs(src, dst, K, dstArr, 0, priceArr);
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        } else {
            return -1;
        }
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Set<Integer> set = new TreeSet<>();

    public void dfs(int src, int dst, int K, ArrayList<Integer>[] dstArr, int cost, int[][] priceArr) {
        if (set.add(dst)) {
            if (K >= 0 && null != dstArr[dst]) {
                for (Integer val : dstArr[dst]) {
                    if (val == src) {
                        minHeap.offer(cost + priceArr[val][dst]);
                    } else {
                        dfs(src, val, K - 1, dstArr, cost + priceArr[val][dst], priceArr);
                        set.remove(dst);
                    }
                }
            }
        }

    }
}
