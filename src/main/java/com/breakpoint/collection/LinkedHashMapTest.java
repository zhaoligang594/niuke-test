package com.breakpoint.collection;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/13
 */
public class LinkedHashMapTest {

    /*
            1. 首先这个类 继承了 HashMap这个类
            2. static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16 默认的大小是 16 而且 无论怎么设置 都是 2 的幂次
            3. 按照插入的顺序进行排序
            4. This class provides all of the optional Map operations, and permits null elements
            5. Note that this implementation is not synchronized
            6.
     */

    public static void main(String[] args) {

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("111", "111");
        hashMap.put("444", "444");
        hashMap.put("222", "222");
        hashMap.put("333", "333");
        Set<String> strings = hashMap.keySet();
        for (String key : strings) {
            System.out.println(key);
        }





    }
}
