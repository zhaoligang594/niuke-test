package com.breakpoint.factory;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/20
 */
public class SingletonTow {

    private SingletonTow() {
    }

    private static volatile SingletonTow INSTANCE = null;

    public static SingletonTow getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonTow.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonTow();
                }
            }
        }
        return INSTANCE;
    }
}
