package juc.volatileDemo;

/**
 * @Description: --------------------------------------
 * @ClassName: VolatileTest02.java
 * @Date: 2021/6/22 23:05
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class VolatileTest02 {

    // volatile 不保证原子性
    private volatile static int num = 0;

    public static void main(String[] args) {
        // 理论上num结果应该为 2 万
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        // main gc
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }

    public static void add() {
        num++;
    }

}
