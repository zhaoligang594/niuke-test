package com.breakpoint.factory;

/**
 * 单例模式
 *
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/20
 */
public class SingletonThree {
    private SingletonThree() {
    }

    private static enum Temp {
        INSTANCE;
        private final SingletonThree instance;

        Temp() {
            instance = new SingletonThree();
        }
    }

    public static SingletonThree getInstance() {
        return Temp.INSTANCE.instance;
    }
}
