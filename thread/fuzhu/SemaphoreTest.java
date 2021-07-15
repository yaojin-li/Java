package fuzhu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 信号量
 * --------------------------------------
 * @ClassName: SemaphoreTest.java
 * @Date: 2021/7/15 23:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        // 线程数量：停车位 限流
        Semaphore semaphore = new Semaphore(3);

        // 6车抢三个停车位
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                //
                try {
                    // acquire() 获得
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // release() 释放
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
