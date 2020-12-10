package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/03
 */
public class Solution784 {

    public static void main(String[] args) {
        System.out.println('A' - 'a');
        List<String> list = new Solution784().letterCasePermutation("a1b2");
        System.out.println(list);
    }

    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        if (null != S && !"".equals(S)) {
            dfs(S, 0, new StringBuilder());
        }
        return res;
    }

    public void dfs(String s, int start, StringBuilder sb) {
        if (s.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        // 获取到我们的字符
        char ch = s.charAt(start);
        if ('Z' >= ch && 'A' <= ch) {
            char[] temp = {ch, (char) (ch + 32)};
            for (int i = 0; i < temp.length; i++) {
                sb.append((char) temp[i]);
                dfs(s, start + 1, sb);
                sb.delete(sb.length() - 1, sb.length());
            }
        } else if ('z' >= ch && 'a' <= ch) {
            char[] temp = {ch, (char) (ch - 32)};
            for (int i = 0; i < temp.length; i++) {
                sb.append((char) temp[i]);
                dfs(s, start + 1, sb);
                sb.delete(sb.length() - 1, sb.length());
            }
        } else {
            sb.append(ch);
            dfs(s, start + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
