package com.breakpoint.collection;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/06
 */
public class HashMapTEst {

    /*
            1. 允许 key=null value=null
            2. 他与 Hashtable 的等效  但是 他不是线程安全的
            3. 无序的 key 无序的
            4。 线程安全的
            5。使用 hash table实现的 transient Node<K,V>[] table;
            6. DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
            7. 底层 红黑树
     */


    public static void main(String[] args) throws Exception{

        HashMap<String, Object> hashMap = new HashMap<>();
    }


//    public static void main(String[] args) {
//        int num=980;
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(tableSizeFor(num)));
//    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
