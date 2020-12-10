package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author breakpoint/赵先生
 * 2020/11/27
 */
@Success
public class Solution554 {

    public int leastBricks(List<List<Integer>> wall) {
        if (null == wall || wall.size() == 0) return 0;
        List<Integer> list = wall.get(0);
        int total = 0;
        for (Integer num : list) {
            total += num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> row : wall) {
            int start = 0;
            for (Integer index : row) {
                start += index;
                map.put(start, map.getOrDefault(start, 0) + 1);
                if (start != 0 && start != total) max = Math.max(max, map.get(start));
            }
        }
        return wall.size() - max;
    }
}
