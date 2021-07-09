package com.breakpoint.leetcode;

import java.util.*;

public class Solution1418 {

    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> res = new TreeMap<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            String food = order.get(2);
            foodSet.add(food);
            Map<String, Integer> tableMap = res.getOrDefault(table, new TreeMap<>());
            tableMap.put(food, tableMap.getOrDefault(food, 0) + 1);
            res.put(table, tableMap);
        }
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);
        List<List<String>> resList = new ArrayList<>();
        List<List<String>> back = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(foodList);
        resList.add(head);
        for (Map.Entry<String, Map<String, Integer>> entry : res.entrySet()) {
            List<String> row = new ArrayList<>();
            String table = entry.getKey();
            Map<String, Integer> value = entry.getValue();
            row.add(table);
            for (String food : foodList) {
                row.add(String.valueOf(value.getOrDefault(food, 0)));
            }
            back.add(row);
        }
        Collections.sort(back, (o1, o2) -> Integer.parseInt(o1.get(0)) - Integer.parseInt(o2.get(0)));
        resList.addAll(back);
        return resList;
    }
}
