package learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //executorService.execute(new Runnable() {})


        ThreadLocal<String> threadLocal2 = new InheritableThreadLocal<>();
        threadLocal2.set("hello");
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
            System.out.println(threadLocal2.get());
        }).start();
    }
}
