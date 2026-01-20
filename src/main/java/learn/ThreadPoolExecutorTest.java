package learn;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/18
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        // 定义一个线程池
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(100));

        System.out.println(threadPoolExecutor.getActiveCount());
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        threadPoolExecutor.prestartAllCoreThreads();
        System.out.println(threadPoolExecutor.getPoolSize());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        threadPoolExecutor.setCorePoolSize(15);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println("maxPoolSize: " + threadPoolExecutor.getMaximumPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getPoolSize());


    }
}
