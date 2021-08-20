package com.breakpoint.leetcode2;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/20
 */
public class Solution541 {

    public static void main(String[] args) {
        String abcdefg = new Solution541().reverseStr("abcd", 2);
        System.out.println(abcdefg);
    }

    /**
     * 反转字符串
     */
    public String reverseStr(String s, int k) {
        // 获取到数组
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; ) {
            // 计算反转的结束位置
            int end = Math.min(start + k, chars.length);
            // 反转区间
            reverseArr(chars, start, end);
            // 下一个开始的位置
            start = end + k;
        }
        return new String(chars);
    }

    // 执行反转的操作
    private void reverseArr(char[] arr, int start, int end) {
        int len = end - start, mid = len / 2;
        for (int i = 0; i < mid; i++) {
            char temp = arr[i + start];
            arr[i + start] = arr[start + len - i - 1];
            arr[start + len - i - 1] = temp;
        }
    }
}
