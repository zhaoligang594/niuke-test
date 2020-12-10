package com.breakpoint.leetcode;

import java.util.*;

/**
 * 332. 重新安排行程
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * middle
 *
 * @author breakpoint/zlg
 * 2020/08/27
 */
public class Solution332 {
    /*
        给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

        说明:

        如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
        所有的机场都用三个大写字母表示（机场代码）。
        假定所有机票至少存在一种合理的行程。
        示例 1:

        输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
        示例 2:

        输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
        解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/reconstruct-itinerary
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        List<String> itinerary = new Solution332().findItinerary(tickets);
        System.out.println(itinerary);
    }

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {

        if (null == tickets || tickets.size() == 0) {
            return new ArrayList<>();
        }
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String curr) {

        // 为了防止进入死胡同 我我们要将 死胡同的元素最后进行访问 就好了
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }

        itinerary.add(curr);
    }
}
