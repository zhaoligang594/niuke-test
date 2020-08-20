package com.breakpoint.leetcode;

/**
 * 415. 字符串相加
 * simple
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/08/03
 */
public class Solution415 {

    /*
        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

        注意：
        num1 和num2 的长度都小于 5100.
        num1 和num2 都只包含数字 0-9.
        num1 和num2 都不包含任何前导零。
        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-strings
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        String s = new Solution415().addStrings("123", "45689");
        System.out.println(s);
    }

    // 模拟竖式加法
    public String addStrings(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();
        int n = Math.max(n1, n2);
        int[] result = new int[n + 1];
        int up = 0;

        int index1 = n1 - 1, index2 = n2 - 1, reIndex = result.length - 1;

        while (index1 >= 0 && index2 >= 0) {
            int i = num1.charAt(index1--) + num2.charAt(index2--) - 2 * '0' + up;
            result[reIndex--] = i % 10 + '0';
            up = i / 10;
        }


        while (index1 >= 0) {
            int i = num1.charAt(index1--) - '0' + up;
            result[reIndex--] = i % 10 + '0';
            up = i / 10;
        }

        while (index2 >= 0) {
            int i = num2.charAt(index2--) - '0' + up;
            result[reIndex--] = i % 10 + '0';
            up = i / 10;
        }
        result[0] = up + '0';

        if (result[0] == '0') {
            return new String(result, 1, result.length - 1);
        } else {
            return new String(result, 0, result.length);
        }


    }

}
