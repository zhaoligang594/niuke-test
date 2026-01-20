package learn;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/24
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(100));
        threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 0;
            }
        });
    }
}
