package com.breakpoint.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : breakpoint
 * create date : 2022/01/30
 * 欢迎关注公众号 《代码废柴》
 */
public class Solution884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (String s : s1s) {
            if (set1.add(s)) {
                set2.add(s);
            } else {
                set2.remove(s);
            }
        }
        for (String s : s2s) {
            if (set1.add(s)) {
                set2.add(s);
            } else {
                set2.remove(s);
            }
        }
        List<String> res = new ArrayList<>(set2);
        return res.toArray(new String[0]);
    }
}
