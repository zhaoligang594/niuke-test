package com.breakpoint.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * 测试动态代理
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/14
 */
public class MyInterfaceTest {


    interface MyInterface {
        void say(String say);
    }

    public static void main(String[] args) {
        MyInvocationHandle<MyInterface> myInvocationHandle = new MyInvocationHandle<MyInterface>(MyInterface.class);
        MyInterface proxyObject = myInvocationHandle.getProxyObject();
        proxyObject.say("qqq");
    }


    static class MyInvocationHandle<T> implements InvocationHandler {

        private Class<T> interfaces;

        public MyInvocationHandle(Class<T> interfaces) {
            this.interfaces = interfaces;
        }

        public T getProxyObject() {
            return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.invoke(proxy, args);
            System.out.println(method.getName());
            return null;
        }
    }
}
