package juc.volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description: --------------------------------------
 * @ClassName: VolatileTest.java
 * @Date: 2021/6/21 23:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class VolatileTest {

    // 没有volatile可能会造成死循环
    // volatile 保证可见性
    private volatile static int num = 0;

    public static void main(String[] args) {
        // 线程1对主内存的变化是不知道的
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);

    }

}
