package com.breakpoint.demos;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin的一个框架信息
 * <p>
 * 在这个中间
 * 一共有2个RecursiveTask、RecursiveAction 后者是没有返回值的操作的
 *
 * @author : breakpoint
 * create date : 2022/02/28
 * 欢迎关注公众号 《代码废柴》
 */
public class MyForkJoinTask extends RecursiveTask<Long> {

    private final Long start;
    private final Long end;

    private static final Long THRESHOLD = 1000L;

    public MyForkJoinTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            MyForkJoinTask left = new MyForkJoinTask(start, middle);
            left.fork(); //拆分子线程 加入到线程的队列中
            MyForkJoinTask right = new MyForkJoinTask(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

    public static void main(String[] args) {
        /*
         *  如何使用的方法
         */
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new MyForkJoinTask(0L, 100000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }
}
