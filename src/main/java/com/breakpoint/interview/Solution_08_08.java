package com.breakpoint.interview;

import java.util.*;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 *
 * @author breakpoint/赵先生
 * 2020/09/04
 */
public class Solution_08_08 {
    /*
        有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

        示例1:

         输入：S = "qqe"
         输出：["eqq","qeq","qqe"]
        示例2:

         输入：S = "ab"
         输出：["ab", "ba"]
        提示:

        字符都是英文字母。
        字符串长度在[1, 9]之间。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/permutation-ii-lcci
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String[] qqes = new Solution_08_08().permutation("OSS");
        System.out.println(Arrays.toString(qqes));
    }

    Set<String> temp = new HashSet<>();
    int[] tag;
    public String[] permutation(String S) {
        if (null == S || "".equals(S)) return new String[]{};
        tag = new int[S.length()];
        dfs(S.toCharArray(), 0, new StringBuilder(), S.length());
        return temp.toArray(new String[0]);
    }

    public void dfs(char[] chars, int start, StringBuilder sb, int n) {
        if (n == 0) {
            System.out.println(sb.toString());
            temp.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > start && chars[i]==chars[i-1]&&tag[i] != 0) continue;
            if(tag[i] == 0){
                tag[i] = 1;
                int len = sb.length();
                sb.append(chars[i]);
                dfs(chars, i+1, sb, n - 1);
                sb.delete(len, sb.length());
                tag[i] = 0;
            }
        }
    }
}
