package com.breakpoint.zw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static final Map<Character, Integer> charToNumber = new HashMap<>();
    static final char[] charTag = {')', '!', '@', '#', '$', '%', '^', '&', '*', '('};

    static {
        charToNumber.put(')', 0);
        charToNumber.put('!', 1);
        charToNumber.put('@', 2);
        charToNumber.put('#', 3);
        charToNumber.put('$', 4);
        charToNumber.put('%', 5);
        charToNumber.put('^', 6);
        charToNumber.put('&', 7);
        charToNumber.put('*', 8);
        charToNumber.put('(', 9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int number1 = getIntVal(sc.next());
            int number2 = getIntVal(sc.next());
            System.out.println(getResult(number1 + number2));
            System.out.println(getResult(number1 - number2));
            System.out.println(getResult(number2 - number1));
            T--;
        }
    }

    private static String getResult(int val) {
        StringBuffer sb = new StringBuffer();
        String valStr = String.valueOf(val);
        for (int i = 0; i < valStr.length(); i++) {
            if (valStr.charAt(i) == '-') {
                sb.append('-');
            } else {
                sb.append(charTag[valStr.charAt(i) - '0']);
            }
        }
        return sb.toString();
    }

    private static int getIntVal(String val) {
        int res = 0, step = 1;
        for (int i = val.length() - 1; i >= 0; i--) {
            if (val.charAt(i) == '-') {
                res = res * -1;
            } else {
                res += step * charToNumber.get(val.charAt(i));
                step *= 10;
            }
        }
        return res;
    }
}
