package com.breakpoint.test;

import java.util.*;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-04
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer first = list.stream().filter(id -> id == 1).findFirst().orElse(null);
        System.out.println(first);
    }

}
