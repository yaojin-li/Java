package juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * 5、增加两个静态的同步方法，只有一个对象，先打印 发短信？打电话？
 * 6、两个对象！增加两个静态的同步方法， 先打印 发短信？打电话？
 * --------------------------------------
 * @ClassName: Test3.java
 * @Date: 2021/5/1 19:31
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class Test3 {
    public static void main(String[] args) {
        // 两个对象，两个调用者，两把锁
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(() -> {
            phone1.call();
        }, "B").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();
    }
}

@SuppressWarnings("all")
class Phone3 {
    /**
     * synchronized 锁的对象是方法的调用者！
     * static 静态方法
     * 类一加载就有了，锁的是class
     */
    public static synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "打电话");
    }

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "发短信");
    }

}
