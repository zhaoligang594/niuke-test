package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/12/06
 */
public class Solution118 {

    /**
     * 生成
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = Collections.singletonList(1);
        res.add(pre);
        int i = 1;
        while (i < numRows) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j + 1 < pre.size(); j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            res.add(cur);
            pre = cur;
            i++;
        }
        return res;
    }
}
