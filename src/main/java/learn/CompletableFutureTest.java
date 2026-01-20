package learn;

import com.breakpoint.thread.LockSupportTest;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static final ExecutorService es =
            new ThreadPoolExecutor(1, 2,
                    200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(12), new ThreadFactory() {
                @Override
                public Thread newThread(@NotNull Runnable r) {
                    Thread t = new Thread(r);
                    ///t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {});
                    t.setDaemon(true);
                    return t;
                }
            });

    public static void main(String[] args) throws Exception {
        // 带有返回值的执行
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello";
        }, es).thenApply((ret) -> {
            System.out.println(Thread.currentThread().getName());
            return ret + " world";
        });
        System.out.println(future.get());
        //es.shutdown();
    }
}
