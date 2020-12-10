package com.breakpoint.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/09/04
 */
public class Offer_38 {

    /*
        输入一个字符串，打印出该字符串中字符的所有排列。

        你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

        示例:

        输入：s = "abc"
        输出：["abc","acb","bac","bca","cab","cba"]
         
        限制：

        1 <= s 的长度 <= 8

        通过次数38,574提交次数70,899

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String[] abcs = new Offer_38().permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }

    public String[] permutation(String s) {
        if (null == s || s.length() == 0) return new String[]{""};
        tag = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars, s.length());
        return list.toArray(new String[0]);
    }

    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] tag;

    public void dfs(char[] chars, int cur) {
        for (int i = 0; i < chars.length; i++) {
            // 剪枝的操作 可以进行有效的剪枝 将同一层的数据进行剪枝了
            if (i > 0 && chars[i - 1] == chars[i] && !tag[i - 1]) continue;
            if (!tag[i]) {
                tag[i] = true;
                int len = sb.length();
                sb.append(chars[i]);
                if (cur == 1) {
                    list.add(sb.toString());
                } else {
                    dfs(chars, cur - 1);
                }
                sb.delete(len, sb.length());
                tag[i] = false;
            }
        }
    }
}
