package com.breakpoint.leetcode;

/**
 * 904. 水果成篮
 *
 * @author breakpoint/赵先生
 * 2020/10/09
 */
public class Solution904 {

    public static void main(String[] args) {
        int[] tree = {1};
        int i = new Solution904().totalFruit(tree);
        System.out.println(i);
    }

    public int totalFruit(int[] tree) {
        int start = 0, end = 0, res = 0, key1 = -1, key2 = -1;
        for (; end < tree.length; ) {
            if (key1 == -1 || tree[end] == key1) {
                key1 = tree[end];
                end++;
            } else if (key2 == -1 || tree[end] == key2) {
                key2 = tree[end];
                end++;
            } else if (tree[end] == key1 || tree[end] == key2) {
                end++;
            } else {
                res = Math.max(res, end - start);
                int k = end - 1;
                while (tree[k] == tree[end - 1]) {
                    k--;
                }
                key1 = tree[end - 1];
                key2 = -1;
                start = k + 1;
            }
        }
        res = Math.max(res, end - start);
        return res;
    }
}
