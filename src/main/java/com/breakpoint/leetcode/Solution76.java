package com.breakpoint.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-25
 */
public class Solution76 {
    public static void main(String[] args) {
        //"ADOBECODEBANC"
        //"ABCC"
        String s = new Solution76().minWindow("a", "a");
        System.out.println(s);
    }

    /*
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
        注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
        示例 1：
        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        示例 2：
        输入：s = "a", t = "a"
        输出："a"
        提示：
        1 <= s.length, t.length <= 105
        s 和 t 由英文字母组成
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/minimum-window-substring
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 采用滑动窗口来实现
        int left = 0, right = 0;
        String res = s + "#";
        Map<Character, Integer> target = new HashMap<>();
        while (right < s.length()) {
            char tarChar = s.charAt(right);
            if (count.containsKey(tarChar)) {
                target.put(tarChar, target.getOrDefault(tarChar, 0) + 1);
            }
            while (left <= right) {
                char tarChar2 = s.charAt(left);
                if (target.containsKey(tarChar2)) {
                    if (check(count, target)) {
                        String substring = s.substring(left, right + 1);
                        if (substring.length() < res.length())
                            res = substring;
                    } else {
                        break;
                    }
                    target.put(tarChar2, target.getOrDefault(tarChar2, 0) - 1);
                }
                left++;
            }
            right++;
        }
        if (right < s.length() && check(count, target)) {
            String substring = s.substring(left, right + 1);
            if (substring.length() < res.length())
                res = substring;
        }
        if (res.contains("#")) return "";
        return res;
    }

    // 校验是否满足这个
    private boolean check(Map<Character, Integer> source, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : source.entrySet()) {
            if (target.getOrDefault(entry.getKey(), 0) < entry.getValue())
                return false;
        }
        return true;
    }

}
