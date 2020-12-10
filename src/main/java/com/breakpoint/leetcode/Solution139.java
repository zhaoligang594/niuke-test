package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记忆化的搜索
 * @author breakpoint/赵先生
 * 2020/11/03
 */
@Success
public class Solution139 {

    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() == 0) return true;
        boolean res = false;
        for (String word : wordDict) {
            if (s.endsWith(word)) {
                boolean b = wordBreak(s.substring(0, s.length() - word.length()), wordDict);
                map.put(s.substring(0, s.length() - word.length()), b);
                if (b) return true;
                res = res || b;
            }
        }
        return res;
    }
}
