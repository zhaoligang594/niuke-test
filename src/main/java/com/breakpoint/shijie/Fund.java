package com.breakpoint.shijie;

import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/10/19
 */
public class Fund {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[7];
        for (int i = 0; i < 7; i++) {
            values[i] = sc.nextDouble();
        }
        int up = 0, down = 0;
        for (int i = 0; i < 7; i++) {
            if (values[i] > 0) {
                up++;
            } else if (values[i] < 0) {
                down++;
            }
        }
        System.out.println(up + "," + down);
    }
}
