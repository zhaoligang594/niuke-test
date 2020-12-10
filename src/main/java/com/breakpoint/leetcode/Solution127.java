package com.breakpoint.leetcode;

import java.util.*;

/**
 * @author breakpoint/赵先生
 * 2020/11/05
 */
public class Solution127 {

    public static void main(String[] args) {
        List<String> word = Arrays.asList("hot","dot","dog","lot","log","cog");
        int i = new Solution127().ladderLength("hit", "cog", word);
        System.out.println(i);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!isHave(wordList, endWord)) return 0;
        Map<String, List<String>> map = new HashMap<>();
        map.put(beginWord, getMInList(wordList, beginWord));
        for (String val : wordList) {
            map.put(val, getMInList(wordList, val));
        }

        int res = dfs(beginWord, endWord, map);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    Set<String> set = new HashSet<>();
    Map<String, Integer> mapCount = new HashMap<>();

    public int dfs(String beginWord, String endWord, Map<String, List<String>> map) {
        if (mapCount.containsKey(beginWord)) return mapCount.get(beginWord);
        List<String> list = map.get(beginWord);
        int res = Integer.MAX_VALUE;
        if (list != null && list.size() > 0) {
            for (String val : list) {
                if (val.equals(endWord)) {
                    return 0;
                } else {
                    if (set.add(val)) {
                        res = Math.min(res, dfs(val, endWord, map) + 1);
                        mapCount.put(val, res);
                        set.remove(val);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private boolean isHave(List<String> wordList, String targetVal) {
        for (String val : wordList) {
            if (val.equals(targetVal)) return true;
        }
        return false;
    }


    private List<String> getMInList(List<String> wordList, String targetVal) {
        List<String> res = new ArrayList<>();
        for (String str : wordList) {
            if (!str.equals(targetVal) && countNotSameNum(str, targetVal) == 1) res.add(str);
        }
        return res;
    }

    private int countNotSameNum(String str1, String str2) {
        if (str1.length() != str2.length()) return 2;
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) res++;
        }
        return res;
    }


}
