package learn;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class ConcurrentHashMapTest {


    public static ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();

    private static final String publicKey = "publicKey";


    public static void main(String[] args) throws Exception {
        /*
            核心的内容：
               key 和 value  都无法为空 否则会有空指针的异常
               插入的流程
               while(true){
                    if(hash 不冲突)：
                        cas 设置新的值
                            如果设置成功 break
                            如果设置失败 continue
                    else hash 冲突：
                        synchronized(冲突节点的node){
                            进行添加
                        }
               }

         */
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(incr(publicKey));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(incr(publicKey));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(incr(publicKey));
            }
        }).start();
        //System.out.println(map.get(publicKey).incrementAndGet());
    }


    public static long incr(String key) {
        map.putIfAbsent(publicKey, new AtomicLong());
        return map.get(publicKey).incrementAndGet();
    }
}
