package com.breakpoint.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-29
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        String s = map.putIfAbsent("a", "a");
        s = map.putIfAbsent("a", "b");
        System.out.println(s);
    }
}
