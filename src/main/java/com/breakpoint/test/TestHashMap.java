package com.breakpoint.test;

import java.util.HashMap;

/**
 * @author breakpoint/zlg
 * 2020/08/25
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(10);
        for (int i = 0; i < 11; i++) {
            map.put("a" + i, i);
        }
    }
}
