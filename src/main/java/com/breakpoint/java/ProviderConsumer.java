package com.breakpoint.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者与消费者的操作
 *
 * @author breakpoint/赵先生
 * 2020/12/04
 */
public class ProviderConsumer {


    public static void main(String[] args) throws Exception {
        ExecutorService provider = Executors.newFixedThreadPool(20);
        ExecutorService consumer = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 40; i++) {
            consumer.submit(new Test.Consumer());
        }

        TimeUnit.SECONDS.sleep(2);

        for (int i = 0; i < 20; i++) {
            provider.submit(new Test.Provider());
        }

    }

}

class Test {
    static volatile Deque<Integer> workQueue = new ArrayDeque<>();

    static AtomicInteger id_gen = new AtomicInteger(0);

    public static class Provider implements Runnable {

        @Override
        public void run() {
            synchronized (ProviderConsumer.class) {
                int id = id_gen.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ":" + id);
                workQueue.offer(id);
                notifyAll();
            }
        }
    }

    public static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (ProviderConsumer.class) {
                    try {
                        while (workQueue.isEmpty()) wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer poll = workQueue.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费者  " + poll);
                }
            }
        }
    }
}
