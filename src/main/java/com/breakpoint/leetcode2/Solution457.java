package com.breakpoint.leetcode2;

import com.breakpoint.annotation.Success;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一个笨笨的方法
 * 官网会有很好的方法
 * <p>
 * https://leetcode-cn.com/problems/circular-array-loop/
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/07
 */
@Success
public class Solution457 {

    // https://leetcode-cn.com/problems/circular-array-loop/
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int next = (i + nums[i] % n + n) % n;
            if (nums[i] > 0) {
                map1.put(i, next);
            } else {
                map2.put(i, next);
            }
        }
        Set<Integer> notLoop = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (notLoop.contains(i)) continue;
            Set<Integer> set = new HashSet<Integer>();
            boolean dfs = dfs(i, set, map1);
            if (dfs) return true;
            notLoop.addAll(set);
        }
        notLoop.clear();
        for (int i = 0; i < nums.length; i++) {
            if (notLoop.contains(i)) continue;
            Set<Integer> set = new HashSet<Integer>();
            boolean dfs = dfs(i, set, map2);
            if (dfs) return true;
            notLoop.addAll(set);
        }
        return false;
    }

    private boolean dfs(int start, Set<Integer> set, Map<Integer, Integer> map1) {
        if (!set.add(start)) return set.size() > 1;// 说明存在环
        Integer next = map1.get(start);
        if (null == next) return false;// 不存在连通性
        return dfs(next, set, map1);
    }
}
