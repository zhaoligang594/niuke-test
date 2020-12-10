package com.breakpoint.leetcode;

import com.breakpoint.utils.GridUtils;

import java.util.*;

/**
 * 834. 树中距离之和
 * 运行超时了。。。。。
 *
 * @author breakpoint/赵先生
 * 2020/10/06
 */
public class Solution834 {

    public static void main(String[] args) {
        int[][] gridByString = GridUtils.getGridByString("[[0,1],[0,2],[2,3],[2,4],[2,5]]");
        int[] ints = new Solution834().sumOfDistancesInTree(6, gridByString);
        System.out.println(1);
    }

    private Map<Integer, List<Integer>> listMap = new HashMap<Integer, List<Integer>>();

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 0) return new int[0];
        if (N == 1) return new int[]{0};
        // 初始化数据
        for (int i = 0; i < N - 1; i++) {
            if (!listMap.containsKey(edges[i][0])) listMap.put(edges[i][0], new ArrayList<>());
            if (!listMap.containsKey(edges[i][1])) listMap.put(edges[i][1], new ArrayList<>());
            listMap.get(edges[i][0]).add(edges[i][1]);
            listMap.get(edges[i][1]).add(edges[i][0]);
        }
        int[] ans = new int[N];
        for (Integer i = 0; i < N; i++) {
            res = 0;
            set.clear();
            set.add(i);
            dfs(i, 0);
            ans[i] = res;
        }
        return ans;
    }

    int res = 0;

    Set<Integer> set = new HashSet<>();

    private void dfs(int start, int deep) {
        res += deep;
        List<Integer> list = listMap.get(start);
        if (null != list) {
            for (Integer key : list) {
                if (!set.add(key)) continue;
                dfs(key, deep + 1);
            }
        }
    }


}
