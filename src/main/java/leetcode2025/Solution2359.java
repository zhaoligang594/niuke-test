package leetcode2025;

import java.util.*;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/30
 */
public class Solution2359 {
    public static void main(String[] args) {
        int i = new Solution2359().closestMeetingNode(new int[]{4, 4, 8, -1, 9, 8, 4, 4, 1, 1}, 5, 6);
    }

    private Map<Integer, Integer> node1Map = new HashMap<>();
    private Map<Integer, Integer> node2Map = new HashMap<>();

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        dfs(edges, node1, 0, node1Map);
        dfs(edges, node2, 0, node2Map);
        int min = Integer.MAX_VALUE;
        int retNode = -1;
        for (int i = 1; i < edges.length; i++) {
            if (node1Map.containsKey(i)
                    && node2Map.containsKey(i)) {
                if (retNode == -1 || Math.max(node1Map.get(i), node2Map.get(i)) < Math.max(node1Map.get(retNode), node2Map.get(retNode))) {
                    min = node1Map.get(i) + node2Map.get(i);
                    retNode = i;
                }
            }
        }
        return retNode;
    }

    private void dfs(int[] edges, int node, int depth, Map<Integer, Integer> nodeMap) {
        if (nodeMap.containsKey(node)) {
            // 没有边
            return;
        }
        nodeMap.put(node, depth);
        if (edges[node] != -1) {
            dfs(edges, edges[node], depth + 1, nodeMap);
        }
    }
}
