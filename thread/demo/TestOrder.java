import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 测试线程指定顺序执行
 * 1. join
 * 2. Executors线程池
 * 3. 运行10个线程，按照顺序打印0123456789
 * --------------------------------------
 * @ClassName: TestOrder.java
 * @Date: 2021/4/7 21:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestOrder {

    /**
     * 声明三个静态线程对象
     */
    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t1线程...");
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t2线程...");
        }
    });

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t3线程...");
        }
    });

    /**
     * 1.使用join阻塞方法控制线程执行顺序
     */
    public static void joinOrder() throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }

    /**
     * 2.使用单线程的线程池
     */
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void executorOrder() {
        // 将任务加入到线程池中
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);

        executorService.shutdown();
    }

    /**
     * 3. 运行10个线程，按照顺序打印0123456789
     * 使用单线程的线程池
     */
    public static void printOrder() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        OrderThreadUsingThreadPool[] orderedThreadsUsingThreadPools = new OrderThreadUsingThreadPool[10];
        for (int i = 0; i < 10; i++) {
            orderedThreadsUsingThreadPools[i] = new OrderThreadUsingThreadPool(i);
            executorService.execute(orderedThreadsUsingThreadPools[i]);
        }
        executorService.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        // 1. join方法
//        joinOrder();

        // 2. 单线程线程池
//        executorOrder();

        // 3. 多线程顺序执行
        printOrder();
    }

}

class OrderThreadUsingThreadPool extends Thread {
    private int id;

    public OrderThreadUsingThreadPool(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(String.format("id[%s], thread[%s] is running...", id, Thread.currentThread().getName()));
    }
}

