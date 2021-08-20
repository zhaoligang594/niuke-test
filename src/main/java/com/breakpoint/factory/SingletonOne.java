package com.breakpoint.factory;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/20
 */
public class SingletonOne {

    private SingletonOne() {
    }

    private static final SingletonOne INSTANCE = new SingletonOne();

    public static SingletonOne getInstance() {
        return INSTANCE;
    }
}
