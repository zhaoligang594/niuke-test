package com.breakpoint.utils;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/21
 */
public class CharArrUtils {

    public static char[] getCharArr(String[] strs) {
        char[] res = new char[strs.length];
        for (int i = 0; i < strs.length; i++) {
            res[i] = strs[i].charAt(0);
        }
        return res;
    }
}
