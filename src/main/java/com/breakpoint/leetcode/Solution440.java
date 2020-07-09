package com.breakpoint.leetcode;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/02
 */
@Deprecated
public class Solution440 {

    public static void main(String[] args) {
        int kthNumber = new Solution440().findKthNumber(13, 5);
        System.out.println(kthNumber);
    }

    // 1..n 字典排序
    public int findKthNumber(int n, int k) {

        // 仅仅会有9中
        int start = 1;

        for (int i = 1; i < 10; i++) {
            int count = getCount(n, i);
            k -= count;
            if (k <= 0) {
                start = i;
                k += count;
                break;
            }
        }

        if (k == 1) {
            return start;
        } else if (k > 1) {
            final int len = (int)Math.pow(10,(n + "").length()-1);
            return start * 10 + findKthNumber(n % len, k - 1);
        }

        return 1;
    }

    // get count for start
    private int getCount(int n, int start) {
        if (n < 10 && start <= n) {
            return 1;
        } else if (n < 10) {
            return 0;
        }
        int count = 0, temp = start, step = 1;

        while (temp < n) {
            count += step;
            temp *= 10;
            step *= 10;
        }
        step /= 10;
        temp /= 10;
        count -= step;
        for (int i = 0; i < 10; i++) {
            count += getCount(n % temp, i);
        }
        return count;
    }


}
