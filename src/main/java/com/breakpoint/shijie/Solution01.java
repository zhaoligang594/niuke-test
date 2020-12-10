package com.breakpoint.shijie;

import java.util.Arrays;

/**
 * @author breakpoint/赵先生
 * 2020/09/24
 */
public class Solution01 {

    public static void main(String[] args) {
        System.out.println(new Solution01().sortVersion("2.x 3.1.x 3.0"));;
    }

    public String sortVersion(String versions) {
        String[] arr = versions.split(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] + arr[j]).compareTo(arr[j] + arr[i]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return Arrays.toString(arr);
    }
}
