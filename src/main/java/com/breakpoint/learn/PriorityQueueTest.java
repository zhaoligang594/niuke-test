package com.breakpoint.learn;

import java.util.PriorityQueue;

/**
 * 优先级队列测试
 *
 * 底层存储结构
 *
 * @author :breakpoint/赵立刚
 * @date : 2020/07/11
 */
public class PriorityQueueTest {

    /*
        优先级队列的测试

        1. private static final int DEFAULT_INITIAL_CAPACITY = 11; 默认大小
        2. A priority queue does not permit null element
        3. 线程是不安全的 如果想使用线程安全的，可以使用 java.util.concurrent.PriorityBlockingQueue
        4. Implementation note: this implementation provides O(log(n)) time for the enqueuing and
           dequeuing methods (offer, poll, remove() and add); linear time for the remove(Object)
           and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size)
        5. 较小的时候，增长2倍+2，比较大的时候，增加一半 50%
        private void grow(int minCapacity) {
            int oldCapacity = queue.length;
            // Double size if small; else grow by 50%
            int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                             (oldCapacity + 2) :
                                             (oldCapacity >> 1));
            // overflow-conscious code
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            queue = Arrays.copyOf(queue, newCapacity);
         6. 底层原理
            应用的是堆排序实现的。
        }
     */
    public static void main(String[] args) {

        // 默认大小
        // 默认按照自然排序的
        PriorityQueue<Integer> queue = new PriorityQueue<>(11);

        queue.add(3);
        queue.add(2);
        queue.add(7);
        queue.add(4);

        for (;!queue.isEmpty();){
            System.out.println(queue.poll());
        }

    }


}
