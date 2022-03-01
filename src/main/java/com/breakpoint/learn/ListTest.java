package com.breakpoint.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : breakpoint
 * create date : 2022/01/20
 * 欢迎关注公众号 《代码废柴》
 */
public class ListTest {

    /**
     * 如果出现ConcurrentModificationException
     * 说明出现
     *
     * @param args
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
        //CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    }


}
