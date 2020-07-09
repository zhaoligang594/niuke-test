package com.breakpoint.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/07/06
 */
@Slf4j
public class VectorTest {

    /*

            1. 线程安全的
            2. 没有容量的变化情况是根据是否给定的 capacityIncrement 来进行判断的，
                给定了：根据 capacityIncrement 增长
                没有： 是原来的2倍
                private void grow(int minCapacity) {
                    // overflow-conscious code
                    int oldCapacity = elementData.length;
                    // 这里是判断的
                    int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                                     capacityIncrement : oldCapacity);
                    if (newCapacity - minCapacity < 0)
                        newCapacity = minCapacity;
                    if (newCapacity - MAX_ARRAY_SIZE > 0)
                        newCapacity = hugeCapacity(minCapacity);
                    elementData = Arrays.copyOf(elementData, newCapacity);
                }
           3. 再有就是底层的实现是数组实现的。protected Object[] elementData;

     */
    // test
    public static void main(String[] args) {
        // initialCapacity 初始化大小
        // 每一次的增量 capacityIncrement
        Vector<Object> vector = new Vector<>(10, 10);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(null);
        vector.add(5);
        Iterator<Object> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        log.info("=====================");

        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }


        log.info("=====================");
        // 1.8 开始的
        vector.forEach((item) -> {
            System.out.println(item);
        });
    }
}
