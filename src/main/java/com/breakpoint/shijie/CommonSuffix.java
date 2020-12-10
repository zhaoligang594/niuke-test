package com.breakpoint.shijie;

import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/10/19
 */
public class CommonSuffix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String values = sc.nextLine();
        values = values.substring(1, values.length() - 1);
        String[] split = values.split("]\\[");
        String[] number1 = split[0].split(" ");
        String[] number2 = split[1].split(" ");
        int len = number1.length > number2.length ? number2.length : number1.length;
        String str = "";
        for (int i = 0; i < len; i++) {
            str += number1[i] + "," + number2[i] + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
        if (number1.length > len) {
            String str2 = "";
            for (int i = len - 1; i < number1.length; i++) {
                str2 += number1[i] + ",";
            }
            System.out.println(str2.substring(0, str2.length() - 1));
        }
        if (number2.length > len) {
            String str2 = "";
            for (int i = len - 1; i < number2.length; i++) {
                str2 += number2[i] + ",";
            }
            System.out.println(str2.substring(0, str2.length() - 1));
        }
    }
}
