package com.breakpoint.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/10/22
 */
public class Solution763 {

    public static void main(String[] args) {
        List<Integer> list = new Solution763().partitionLabels("a");
        System.out.println(list);
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() == 0) {
            res.add(0);
        } else {
            // 26个字母的最后的位置
            int[] letter = new int[26];
            Arrays.fill(letter, -1); // 设置默认值
            int len = S.length();
            for (int i = len - 1; i >= 0; i--) {
                if (-1 == letter[S.charAt(i) - 'a']) letter[S.charAt(i) - 'a'] = i;
            }
            // 从前向后查找最后的位置
            for (int i = 0; i < len; ) {
                int max_r = letter[S.charAt(i) - 'a'], k = i;
                // 找到当前字符串内部没有其他的字母 那么就是最长的一个子部分
                while (k < len && k < max_r) {
                    max_r = Math.max(max_r, letter[S.charAt(k) - 'a']);
                    k++;
                }
                // 得到一个单一的结果
                res.add(max_r - i + 1);
                // 继续向下寻找
                i = max_r + 1;
            }
        }
        return res;
    }
}
