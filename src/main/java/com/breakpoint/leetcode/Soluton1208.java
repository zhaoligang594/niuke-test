package com.breakpoint.leetcode;

/**
 * 1208. 尽可能使字符串相等
 * middle
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-02-05
 */
public class Soluton1208 {

    //"abcd"
    //"bcdf"
    //3
    public static void main(String[] args) {
        int i = new Soluton1208().equalSubstring("abcd", "bcdf", 3);
        System.out.println(i);
    }

    /**
     * 采用双指针来进行实现
     *
     * @param s       第一个字符串
     * @param t       第二个字符串
     * @param maxCost 最高的花费
     * @return 返回最长的字串
     */
    public int equalSubstring(String s, String t, int maxCost) {
        // 设置双指针 左位置 右位置 返回值 以及 总体的花费
        int left = 0, right = 0, res = 0, totalCost = 0;
        // 计算字符串的长度
        int n = s.length();
        // 循环求解
        for (; right < n; right++) {
            // 计算当前的花费
            int cost = Math.abs(s.charAt(right) - t.charAt(right));
            // 计算总花费
            totalCost += cost;
            // 判断是否超过预期
            if (totalCost > maxCost) {
                // 超过预期最大值的处理
                while (totalCost > maxCost) {
                    int costA = Math.abs(s.charAt(left) - t.charAt(left));
                    totalCost -= costA;
                    left++;
                }
                // 计算最大的字串
                res = Math.max(res, right - left + 1);
            } else {
                // 计算
                res = Math.max(res, right - left + 1);
            }
        }
        // because right is the next location
        res = Math.max(res, right - left);
        return res;
    }
}
