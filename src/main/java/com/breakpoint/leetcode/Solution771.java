package com.breakpoint.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author breakpoint/赵先生
 * 2020/10/02
 */
public class Solution771 {
    public static void main(String[] args) {
        int i = new Solution771().numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }

    public int numJewelsInStones(String J, String S) {
        if (null == J || J.equals("")) return 0;
        if (null == S || S.equals("")) return 0;

        int res = 0;
        Set<Character> set = new HashSet<>();
        for (Character ch : J.toCharArray()) {
            set.add(ch);
        }
        for (Character ch : S.toCharArray()) {
            if (set.contains(ch)) {
                res++;
            }
        }
        return res;
    }
}
