package com.breakpoint.learn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author breakpoint/赵先生
 * 2020/11/30
 */
public class OOMTest {

    static class OOMObject {
    }

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        List<Object> objects = new ArrayList<>();
        int i=0;
        while (true) {
//            unsafe.allocateMemory(_1MB);
//            objects.add(new Object());
            String intern = String.valueOf("挥洒圣诞卡浑善达克哈数据库电话卡时代大厦路口都好啦开始打"+i).intern();
        }
    }
}
