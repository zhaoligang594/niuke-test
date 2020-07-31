package com.breakpoint.leetcode;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class SolutionOffer67 {


    public static void main(String[] args) {
        int i = new SolutionOffer67().strToInt("-999999999999999");
        System.out.println(i);
    }

    public int strToInt(String str) {

        if (null == str || str.length() == 0) {
            return 0;
        }

        if (str.length() == 1 && ('-' == str.charAt(0) || '+' == str.charAt(0))) {
            return 0;
        }

        int start = 0;
        char chStart = str.charAt(start);
        if (chStart == ' ') while (start < str.length() && ' ' == (chStart = str.charAt(start))) start++;

        if (chStart == '-' || chStart == '+' || (chStart <= '9' && chStart >= '0')) {
            if (chStart == '-' || chStart == '+' || (chStart <= '9' && chStart >= '0')) {
                int unit = 1;
                if (chStart == '-') {
                    unit = -1;
                    start++;
                    chStart = str.charAt(start);
                } else if (chStart == '+') {
                    start++;
                    chStart = str.charAt(start);
                }
                long sum = 0;
                while (start < str.length() && (chStart <= '9' && chStart >= '0')) {
                    sum = sum * 10 + chStart - '0';
                    if (sum > Integer.MAX_VALUE) {
                        break;
                    }
                    start++;
                    if (start < str.length()) {
                        chStart = str.charAt(start);
                    }
                }

                sum = unit * sum;

                if (sum < Integer.MAX_VALUE && sum > Integer.MIN_VALUE) {
                    return ((int) sum);
                } else if (sum >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
