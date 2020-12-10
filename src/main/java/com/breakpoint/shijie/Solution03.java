package com.breakpoint.shijie;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/09/27
 */
public class Solution03 {

    public static void main(String[] args) {
        int i = new Solution03().graph_circle_checker("{(A->B),(B->C),(C->A)}");
        System.out.println(i);
    }

    public int graph_circle_checker(String graph_string) {
        if (null == graph_string || "".equals(graph_string)) return -1;
        String temp = graph_string.replaceAll(",", "");
        String regex = "^\\{(\\([A-Z]{1}->[A-Z]{1}\\))*\\}$";
        if (temp.matches(regex)) {
            if ("{}".equals(graph_string)) return 0;
            graph_string = graph_string.substring(2, graph_string.length() - 2);
            String[] split = graph_string.split("\\),\\(");
            Map<String, List<String>> map = new HashMap<>();
            String startNode = null;
            for (String str : split) {
                String[] inner = str.split("->");
                if (!map.containsKey(inner[0])) map.put(inner[0], new ArrayList<>());
                map.get(inner[0]).add(inner[1]);
                if (startNode == null) {
                    startNode = inner[0];
                }
            }
            if (isHaveSircle(map, startNode)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    Set<String> nodeSet = new HashSet<>();

    private boolean isHaveSircle(Map<String, List<String>> map, String startNode) {
        if (nodeSet.add(startNode)) {
            List<String> list = map.get(startNode);
            if (null == list || list.size() == 0) return false;
            boolean res = false;
            for (String node : list) {
                res |= isHaveSircle(map, node);
                nodeSet.remove(node);
            }
            return res;
        } else {
            return true;
        }
    }

}
