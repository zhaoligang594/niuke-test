package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/09/17
 */
public class Solution278 {

    public static void main(String[] args) {
        int i = new Solution278().firstBadVersion(2126753390);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            // 注意一下越界的情况
            int middle = lo + (hi - lo) / 2;
            if (isBadVersion(middle)) {
                hi = middle;
            } else {
                lo = middle + 1;
            }
        }
        return lo;
    }

    //2126753390
    //1702766719
    private boolean isBadVersion(int middle) {
        if (middle < 1702766719) {
            return false;
        } else {
            return true;
        }
    }
}
