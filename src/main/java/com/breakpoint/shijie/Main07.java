package com.breakpoint.shijie;

/**
 * @author breakpoint/赵先生
 * 2020/09/24
 */
public class Main07 {

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n + 1][n + 1];
        arr[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][i - j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
