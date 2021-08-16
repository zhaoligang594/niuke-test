package com.breakpoint.leetcode;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class Solution67 {

    /*
        给你两个二进制字符串，返回它们的和（用二进制表示）。

        输入为 非空 字符串且只包含数字 1 和 0。

         

        示例 1:

        输入: a = "11", b = "1"
        输出: "100"
        示例 2:

        输入: a = "1010", b = "1011"
        输出: "10101"
         

        提示：

        每个字符串仅由字符 '0' 或 '1' 组成。
        1 <= a.length, b.length <= 10^4
        字符串如果不是 "0" ，就都不含前导零。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-binary
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        String s = new Solution67().addBinary("10", "0");
        System.out.println(s);
    }

    // 是错误的 如果位数超过了已知的，就会产生问题
    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    // 二进制求和的操作
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        int i = 1, pre = 0;
        while (lenA >= i && lenB >= i) {
            int temp = (a.charAt(lenA - i) - '0' + b.charAt(lenB - i) - '0' + pre);
            result[result.length - i] = temp % 2 + '0';
            pre = temp / 2;
            i++;
        }
        while (lenA >= i) {
            int temp = (a.charAt(lenA - i) - '0' + pre);
            result[result.length - i] = temp % 2 + '0';
            pre = temp / 2;
            i++;
        }
        while (lenB >= i) {
            int temp = (b.charAt(lenB - i) - '0' + pre);
            result[result.length - i] = temp % 2 + '0';
            pre = temp / 2;
            i++;
        }
        result[0] = pre + '0';
        return result[0] == '0' ? new String(result, 1, result.length - 1) : new String(result, 0, result.length);
    }
}
