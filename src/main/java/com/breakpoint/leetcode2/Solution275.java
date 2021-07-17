package com.breakpoint.leetcode2;

/**
 * 因为有序 所以可以采用二分查找的方式进行求解结果,
 */
public class Solution275 {

    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
