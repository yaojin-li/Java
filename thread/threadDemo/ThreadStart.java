
/**
 * @Description:
 * 1. 创建：集成Thread+重写run
 * 2. 启动：创建子类对象 + start
 * --------------------------------------
 * @ClassName: ThreadStart.java
 * @Date: 2020/6/20 15:15
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ThreadStart extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread run...");
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        ThreadStart threadStart = new ThreadStart();
        // 启动（执行run方法的线程要在当前任务之前调用，保证实现多线程调用）
        threadStart.start();//不保证立即运行，由CPU调用

        // 普通方法调用
        // threadStart.run();

        for (int i = 0; i < 10; i++) {
            System.out.println("main run...");
        }
    }


}
