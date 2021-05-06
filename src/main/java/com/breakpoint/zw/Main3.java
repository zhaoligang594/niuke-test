package com.breakpoint.zw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-04-21
 */
public class Main3 {

    public int[] margeFourArrays(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        int[] merge = merge(arr1, arr2);
        int[] merge1 = merge(arr3, arr4);
        return merge(merge, merge1);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[index++] = arr1[i++];
            } else {
                res[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            res[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            res[index++] = arr1[j++];
        }
        return res;
    }
}
