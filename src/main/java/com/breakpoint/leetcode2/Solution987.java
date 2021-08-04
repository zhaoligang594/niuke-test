package com.breakpoint.leetcode2;

import com.breakpoint.utils.TreeNode;

import java.util.*;

public class Solution987 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // key: index_depth
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        buildMap(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> tempMap = new HashMap<>();
        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            int index = Integer.parseInt(key.substring(0, key.indexOf("_")));
            int depth = Integer.parseInt(key.substring(key.indexOf("_") + 1));
            Map<Integer, List<Integer>> listMap = tempMap.getOrDefault(index, new HashMap<>());
            List<Integer> list = listMap.getOrDefault(depth, new ArrayList<>());
            while (!entry.getValue().isEmpty()) {
                list.add(entry.getValue().poll());
            }
            listMap.put(depth, list);
            tempMap.put(index, listMap);
        }
        for (int k = min; k <= max; k++) {
            if(tempMap.containsKey(k)){
                List<Integer> temp = new ArrayList<>();
                for (int d = 0; d <= maxDepth; d++) {
                    Map<Integer, List<Integer>> listMap = tempMap.get(k);
                    if (listMap.containsKey(d)) {
                        temp.addAll(listMap.get(d));
                    }
                }
                res.add(temp);
            }
        }
        return res;
    }

    static int min = 0, max = 0, maxDepth = 0;

    private void buildMap(TreeNode root, int index, int depth, Map<String, PriorityQueue<Integer>> map) {
        if (null != root) {
            min = Math.min(min, index);
            max = Math.max(max, index);
            maxDepth = Math.max(maxDepth, depth);
            String key = String.format("%s_%s", index, depth);
            PriorityQueue<Integer> p = map.getOrDefault(key, new PriorityQueue<>());
            p.offer(root.val);
            map.put(key, p);
            buildMap(root.left, index - 1, depth + 1, map);
            buildMap(root.right, index + 1, depth + 1, map);
        }
    }
}
