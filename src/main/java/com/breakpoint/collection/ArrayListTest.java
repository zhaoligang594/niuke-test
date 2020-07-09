package com.breakpoint.collection;

import java.util.ArrayList;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/06
 */
public class ArrayListTest {

    /*
            1. 线程不安全的类   List list = Collections.synchronizedList(new ArrayList(...));
            2. private static final int DEFAULT_CAPACITY = 10; 默认的容量大小 10
            3. transient Object[] elementData; 使用数组实现的
            4. 每次修改容量都是变为 最小容量的1.5倍
                private void grow(int minCapacity) {
                    // overflow-conscious code
                    int oldCapacity = elementData.length;
                    int newCapacity = oldCapacity + (oldCapacity >> 1);
                    if (newCapacity - minCapacity < 0)
                        newCapacity = minCapacity;
                    if (newCapacity - MAX_ARRAY_SIZE > 0)
                        newCapacity = hugeCapacity(minCapacity);
                    // minCapacity is usually close to size, so this is a win:
                    elementData = Arrays.copyOf(elementData, newCapacity);
                }
            5.
     */

    public static void main(String[] args) {

        // create object
        ArrayList<Object> list=new ArrayList<>(16);

        list.add(1);
        list.add(null);

        for (Object o:list){
            System.out.println(o);
        }



    }
}
