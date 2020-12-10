package com.breakpoint.leetcode;

/**
 * 214. 最短回文串
 * <p>
 * https://leetcode-cn.com/problems/shortest-palindrome/solution/shi-jian-fu-za-du-on-jie-fa-la-che-by-time-limit/
 *
 * @author breakpoint/zlg
 * 2020/08/29
 */
public class Solution214 {

    /*
        给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

        示例 1:

        输入: "aacecaaa"
        输出: "aaacecaaa"
        示例 2:

        输入: "abcd"
        输出: "dcbabcd"
        通过次数11,778提交次数35,724

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shortest-palindrome
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String aacecaaa = new Solution214().shortestPalindrome("babbbabbaba");
        System.out.println(aacecaaa);
    }


    public String shortestPalindrome(String s) {
        if (null == s || s.length() == 0 || s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        sb.reverse();
        if (s.equals(sb.toString().replaceAll("#", ""))) return s;
        s = sb.toString();
        int[] radis = new int[s.length()];
        int c = 0, R = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i >= R) {
                int k = 1;
                while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                    k++;
                }
                radis[i] = k - 1;
            } else {
                int L = 2 * c - R;// 左面的点
                int ii = 2 * c - i;
                if (ii - radis[ii] <= L) {
                    radis[i] = R - i;
                } else {
                    radis[i] = radis[ii];
                }
                // 再一次尝试扩张
                int k = radis[i];
                while (i - k >= 0 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) {
                    k++;
                }
                radis[i] = k - 1;
            }
            if (i + radis[i] > R) {
                R = i + radis[i];
                c = i;
            }
            // 结尾的位置
            if (radis[i] + i == s.length() - 1) {
                StringBuilder sb2 = new StringBuilder();
                String temp = s.substring(0, i - radis[i]);
                sb2.append(temp).reverse();
                return (s + sb2.toString()).replaceAll("#", "");

            }
        }
        return null;
    }
}
