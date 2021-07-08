package juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 同步队列测试
 * --------------------------------------
 * @ClassName: SynchronousQueueTest.java
 * @Date: 2021/7/8 23:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SynchronousQueueTest {

    /**
     * 同步队列
     * 和其他的 BlockingQueue 不一样，SynchronousQueue 不存储元素
     * put元素后必须先take取出来，否则不能再put进去值
     */
    public static void main(String[] args) {
        // 同步队列
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 3");
                blockingQueue.put("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            // TODO LXJ 疑问点：当此时sleep时间去掉，或时间很短1s，会出现连续放入两个元素，再顺序取出来的情况。
            /*
                T1put 1
                T1put 2
                T2=>1
                T2=>2
                T1put 3
                T2=>3
            * */
            try {
//                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
//                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
//                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "T2").start();

    }

}
