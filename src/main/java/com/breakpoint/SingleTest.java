package com.breakpoint;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-12
 */
public class SingleTest {
    public static void main(String[] args) {
        Object object = Single.INSTANCE.getObject();
        Object object2 = Single.INSTANCE.getObject();
        System.out.println(object == object2);
    }
}

enum Single {

    INSTANCE(null);

    private Object object;

    private Single(Object object) {
        this.object = new Object();
    }

    public Object getObject() {
        return this.object;
    }
}

