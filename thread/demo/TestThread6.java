/**
 * @Description: 测试线程停止stop
 * 1. 建议线程正常停止：利用次数，不建议死循环；
 * 2. 建议使用标志位：设置一个标志位；
 * 3. 不要使用stop或者destroy等过时或JDK不建议使用的方法
 * --------------------------------------
 * @ClassName: TestThread6.java
 * @Date: 2021/4/6 22:39
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread6 implements Runnable {

    /**
     * 1.设置一个标志位
     */
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    /**
     * 2.设置一个公开的方法停止线程，转换标志位
     */
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        // 开启多线程
        TestThread6 testThread6 = new TestThread6();
        new Thread(testThread6).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main" + i);
            if (i == 90) {
                // 3. 调用stop方法切换标志位，停止线程
                // 停止执行run()方法
                testThread6.stop();
                System.out.println("重写run方法的线程停止...");
            }
        }
    }

}
