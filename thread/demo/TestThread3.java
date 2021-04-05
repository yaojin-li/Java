/**
 * @Description:
 * 1. 创建线程方式二：实现Runnable接口，重写run()方法，执行线程需要丢入runnable接口实现类，调用start方法
 * --------------------------------------
 * @ClassName: TestThread3.java
 * @Date: 2021/4/5 11:08
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("thread线程开启..." + i);
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        /*
            创建线程对象，通过线程对象开启线程。代理
            Thread thread = new Thread(testThread3);
            thread.start();
        * */

        new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main线程开启..." + i);
        }
    }

}
