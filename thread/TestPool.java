import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: --------------------------------------
 * @ClassName: TestPool.java
 * @Date: 2021/4/15 21:13
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestPool {
    public static void main(String[] args) {
        // 1. 创建服务，创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 2. 执行
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        // 3. 关闭
        executorService.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


