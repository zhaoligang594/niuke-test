package com.breakpoint.leetcode;

public class Intever1710 {

    public static void main(String[] args) {
        String a = "ja" + "va";
        System.out.println(a == a.intern());
        String b = "te" + "st";
        System.out.println(b == b.intern());
    }

}
