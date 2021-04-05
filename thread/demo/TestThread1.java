
/**
 * @Description:
 * 1. 创建线程方式一：继承Thread类+重写run()方法，调用start()方法开启线程
 * 2. 注意：线程开启不一定立即执行，由CPU调度执行
 *
 * start()方法调用，多条执行路径，主线程和子线程并行交替执行
 * run()方法调用，只有主线程一条执行路径。此时非多线程。
 * --------------------------------------
 * @ClassName: TestThread1.java
 * @Date: 2020/6/20 15:15
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("thread线程开启..." + i);
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        TestThread1 testThread1 = new TestThread1();
        // 不保证立即运行，由CPU调用
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main线程开启..." + i);
        }
    }

}
