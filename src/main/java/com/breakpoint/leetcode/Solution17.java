package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 * @author breakpoint/zlg
 * 2020/08/26
 */
@Success
public class Solution17 {


    private static Map<Character, String> map = new HashMap<>(8);

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public static void main(String[] args) {
        List<String> strings = new Solution17().letterCombinations("2");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {

        if (null == digits || "".equals(digits)) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            Character ch = digits.charAt(i);
            String sequences = map.get(ch);
            if (temp.size() == 0) {
                for (int j = 0; j < sequences.length(); j++) {
                    sb.append(sequences.charAt(j));
                    temp.add(sb.toString());
                    if (sb.toString().length() == digits.length()) {
                        res.add(sb.toString());
                    }
                    sb.delete(0, sb.length());
                }
            } else {
                List<String> unit = new ArrayList<>();
                for (int k = 0; k < temp.size(); k++) {
                    sb.append(temp.get(k));
                    for (int j = 0; j < sequences.length(); j++) {
                        sb.append(sequences.charAt(j));
                        unit.add(sb.toString());
                        if (sb.toString().length() == digits.length()) {
                            res.add(sb.toString());
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.delete(0, sb.length());
                }
                temp.clear();
                temp.addAll(unit);
            }
            sb.delete(0, sb.length());
        }
        return res;
    }
}
