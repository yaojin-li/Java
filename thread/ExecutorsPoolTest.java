import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: --------------------------------------
 * @ClassName: ExecutorsPoolTest.java
 * @Date: 2021/7/4 12:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ExecutorsPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                // 队列满了，尝试去和最早的竞争，也不会抛出异常！
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，线程结束，关闭线程池
            threadPool.shutdown();
        }

    }
}
