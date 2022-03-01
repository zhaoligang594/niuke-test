package com.breakpoint.learn;

import java.lang.ref.SoftReference;

/**
 * @author : breakpoint
 * create date : 2022/02/22
 * 欢迎关注公众号 《代码废柴》
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        // 仅仅是把这个的对象进行了缓存，得到的最终的结果
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        o1 = null;
        System.out.println(softReference.get());

        try {
            byte[] bytes = new byte[6 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 这个时候获取一下数据
            System.out.println(softReference.get());
        }
    }
}
