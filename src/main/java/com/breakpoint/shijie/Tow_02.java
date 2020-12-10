package com.breakpoint.shijie;

/**
 * @author breakpoint/赵先生
 * 2020/09/09
 */
public class Tow_02 {

    public static void main(String[] args) {
        for (int x1 = 0; x1 <= 9; x1++) {
            for (int x2 = 0; x2 <= 9; x2++) {
                for (int x3 = 0; x3 <= 9; x3++) {
                    for (int x4 = 0; x4 <= 9; x4++) {
                        if (x1 * 1000 + x2 * 100 + x3 * 10 + x4 + x2 * 1000 + x3 * 100 + x4 * 10 + x1 == 8888) {
                            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
                        }
                    }
                }
            }
        }
    }
}
