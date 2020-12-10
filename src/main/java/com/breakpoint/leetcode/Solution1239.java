package com.breakpoint.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1239. 串联字符串的最大长度
 *
 * @author breakpoint/赵先生
 * 2020/09/04
 */
public class Solution1239 {
    /*
        给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
        请返回所有可行解 s 中最长长度。
        示例 1：
        输入：arr = ["un","iq","ue"]
        输出：4
        解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
        示例 2：
        输入：arr = ["cha","r","act","ers"]
        输出：6
        解释：可能的解答有 "chaers" 和 "acters"。
        示例 3：
        输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
        输出：26
        提示：
        1 <= arr.length <= 16
        1 <= arr[i].length <= 26
        arr[i] 中只含有小写英文字母

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("un", "iq", "ue");
        int i = new Solution1239().maxLength(list);
        System.out.println(i);
    }


    int res;
    public int maxLength(List<String> arr) {
        if (null == arr || arr.size() == 0) return 0;
        dfs(arr, 0, new StringBuilder());
        return res;
    }

    public void dfs(List<String> arr, int start, StringBuilder sb) {
        for (int i = start; i < arr.size(); i++) {
            // 剪枝操作
            if (isHaveSameChar(arr.get(i)) || isHaveSameChar(sb.toString(), arr.get(i))) continue;
            int length = sb.length();
            sb.append(arr.get(i));
            res = Math.max(res, sb.length());
            dfs(arr, i + 1, sb);
            sb.delete(length, sb.length());
        }
    }

    private boolean isHaveSameChar(String str1) {
        char[] charsStr1 = str1.toCharArray();
        Arrays.sort(charsStr1);
        for (int i = 1; i < charsStr1.length; i++) {
            if (charsStr1[i - 1] == charsStr1[i]) return true;
        }
        return false;
    }

    private boolean isHaveSameChar(String str1, String str2) {
        char[] charsStr1 = str1.toCharArray();
        Arrays.sort(charsStr1);
        char[] charsStr2 = str2.toCharArray();
        Arrays.sort(charsStr1);
        for (int i = 0, j = 0; i < charsStr1.length && j < charsStr2.length; ) {
            if (charsStr1[i] > charsStr2[j]) {
                j++;
            } else if (charsStr1[i] < charsStr2[j]) {
                i++;
            } else {
                return true;
            }
        }
        // 没有相同的元素
        return false;
    }

}
