package com.breakpoint.learn;

/**
 * 测试 synchronized 和 exception 的 异常的对比
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/06
 */
public class TestTryCacheException {

    public void test() {
        synchronized (this) {
            throw new RuntimeException();
        }
    }
}
