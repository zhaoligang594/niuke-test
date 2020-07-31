package com.breakpoint.shijie;

import java.util.Arrays;
import java.util.List;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/22
 */
public class T2 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3, 7, 9, 10, 11};
        f(nums);
    }

    public static int[] f(int[] arr) {

        if (null == arr) {
            return null;
        }
        if (arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        Arrays.sort(arr);
        int len = n / 2 + n % 2;
        int[] val = new int[len];
        for (int i = 0, j = 0; i < n; i += 2, j++) {
            val[j] = arr[i];
        }
        return val;
    }
}
