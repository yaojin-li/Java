package fuzhu;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: CountDownLatch
 * 计数器
 * --------------------------------------
 * @ClassName: CountDownLatchTest.java
 * @Date: 2021/7/15 23:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6，必须要执行任务的时候，再使用！
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                // 数量-1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        // 等待计数器归零，继续执行
        countDownLatch.await();
        System.out.println("close door");
    }
}
