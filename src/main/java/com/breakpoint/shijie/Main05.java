package com.breakpoint.shijie;

import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/09/18
 */
public class Main05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double m = (max3(a + b, b, c) * 1.0) / (max3(a, b + c, c) + max3(a, b, b + c));
        System.out.println((double)Math.round(m*100)/100);
    }


    private static int max3(int a, int b, int c) {
        int max = Math.max(a, b);
        return Math.max(max, c);
    }
}
