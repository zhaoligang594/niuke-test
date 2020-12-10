package com.breakpoint.leetcode;

/**
 * @author breakpoint/赵先生
 * 2020/10/23
 */
public class Solution1616 {

    //"xbdef"
    //"xecab"
    public static void main(String[] args) {
        boolean b = new Solution1616().checkPalindromeFormation("ulacfd", "jizalu");
        System.out.println(b);
    }

    public boolean checkPalindromeFormation(String a, String b) {
        char[] charArrA = getCharArr(a);
        char[] charArrB = getCharArr(b);
        for (int i = 0; i < charArrA.length; i++) {
            if (manacher2(charArrA, charArrB, i)) return true;
        }
        for (int i = 0; i < charArrA.length; i++) {
            if (manacher2(charArrB, charArrA, i)) return true;
        }
        return false;
    }

    public boolean manacher2(char[] a, char[] b, int index) {
        int[] raduis = new int[a.length];
        int C = 0;
        int R = -1;

        for (int i = 0; i < a.length; i++) {
            raduis[i] = i >= R ? 1 : Math.min(i - C, R - C);
            while (i - raduis[i] >= 0 && i + raduis[i] < a.length && getChar(a, b, index, i + raduis[i]) == getChar(a, b, index, i - raduis[i]))
                raduis[i]++;
            raduis[i]--;
            if (i + raduis[i] > R) {
                C = i;
                R = i + raduis[i];
            }
            if (i == a.length / 2) {
                return raduis[i] + i >= a.length-1;
            }
        }
        return false;
    }

    private char getChar(char[] a, char[] b, int index, int cur) {
        if (cur <= index) {
            return a[cur];
        } else {
            return b[cur];
        }
    }


    private char[] getCharArr(String s) {
        char[] res = new char[2 * s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i % 2 == 0) ? '#' : s.charAt(i / 2);
        }
        return res;
    }
}
